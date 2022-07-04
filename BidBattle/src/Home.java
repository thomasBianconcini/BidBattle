import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import com.ibm.icu.impl.coll.CollationWeights;

import controller.HomeNonAutenticataController;
import model.Asta;
import model.DbMock;
import model.Utente;

import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;

public class Home {

	protected Shell shell;
	private Text txtRicercaPerUtente;
	private Display display = Display.getDefault();
	DbMock db =new DbMock();
	private int pagina =1;
	private List<Label> titoli = new ArrayList<>();
	private List<Label> descrizioni = new ArrayList<>();
	private List<Button> bottoni = new ArrayList<>();
	private List<Composite> quadrati = new ArrayList<>();
	private boolean check= true;
	private Text txtRicercaPerEmail;
	private static MouseAdapter ma;
	List<Asta> ricA = new ArrayList<Asta>();
	List<Utente> ricU = new ArrayList<Utente>();
	List<Integer> pag= new ArrayList<Integer>();
	private boolean ricerca=false;
	List<VediAsta> current=  new ArrayList<VediAsta>();
	private int count =0;
	private Shell toOpen=null;
	private boolean stoRicercando=false;
	/**
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Home window = new Home();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell(display);
		shell.setSize(1920, 1080);
		List<Asta> aste= DbMock.getAsteDaMostare();
		shell.setFullScreen(true);
		shell.setText("Home");
		shell.setBackground(SWTResourceManager.getColor(255, 215, 0));
		Label label = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label.setBackground(SWTResourceManager.getColor(255, 215, 0));
		Point p= shell.getSize();
		label.setBounds(p.x*20/100, -19, 2, 1080);
		
		Label label_1 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		label_1.setBounds(-11, 384, p.x*20/100, 2);
		
		
		Label label_1_1 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		label_1_1.setBounds(-11, 523, 384, 2);
		
		Label label_2 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_2.setBackground(SWTResourceManager.getColor(255, 215, 0));
		label_2.setBounds(-11, 1080,p.x*20/100, 2);
		
		Label label_1_2 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1_2.setBackground(SWTResourceManager.getColor(255, 215, 0));
		label_1_2.setBounds(-11, 1078, p.x*20/100, 10);
		Button btnCheckButton = new Button(shell, SWT.CHECK);
		btnCheckButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				pagina=1;
			}
		});
		btnCheckButton.setBounds(1381, 159, 93, 23);
		btnCheckButton.setText("Utente");
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				Home pp = new Home();
				shell.close();
				pp.open();
			}
		});
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.BOLD));
		lblNewLabel.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel.setBounds(153, 438, 78, 37);
		lblNewLabel.setText("Home");
		
		Label lblNewLabel_1_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				InterazioneAste ia= new InterazioneAste();
				shell.close();
				ia.open();
			}
		});
		lblNewLabel_1_1.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.BOLD));
		lblNewLabel_1_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_1_1.setText("Interazione Asta");
		lblNewLabel_1_1.setBounds(100, 994, 217, 37);
		
		Label lblNewLabel_4 = new Label(shell, SWT.NONE);
		lblNewLabel_4.setBounds(0, 0, 382, 382);
		lblNewLabel_4.setImage(new Image(display,"logo.jpg"));
		Group grpLeMieAste = new Group(shell, SWT.BORDER);
		grpLeMieAste.setBackground(SWTResourceManager.getColor(255, 215, 0));
		grpLeMieAste.setBounds(480, 200, 1104, 1000);
		Label lblAsta=null;
		Button btnNewButton = null;
		Label lblTitoloAsta = null;
		Composite composite = null;
		
		if(stoRicercando)
			mostra(ricA,pagina,grpLeMieAste,lblAsta,btnNewButton,lblTitoloAsta,composite);
		else
		mostra(aste,pagina,grpLeMieAste,lblAsta,btnNewButton,lblTitoloAsta,composite);
		Button btnNewButton_1 = new Button(grpLeMieAste, SWT.NONE);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if(!btnCheckButton.getSelection())
				{
					if(check)
					{
						if(!stoRicercando)
						{
						pagina = pagina +1;
						mostra(aste,pagina);
						}
						else
						{
							pagina = pagina +1;
							mostra(ricA,pagina);
						}
					}
				}else
				{
					if(check)
					{
						System.out.println("ciao");
						if(ricU!=null)
						{
							System.out.println("ciao");
						pagina = pagina +1;
						mostraUtente(ricU,pagina);
						}
					}
				}
			}
		});
		btnNewButton_1.setBounds(1007, 47, 75, 25);
		btnNewButton_1.setText("Avanti");
		
		Button btnNewButton_2 = new Button(grpLeMieAste, SWT.NONE);
	
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if(!btnCheckButton.getSelection())
				{
					if(pagina!=1)
					{
						if(!stoRicercando)
						{
						pagina = pagina -1;
						mostra(aste,pagina);
						}
						else
						{
							pagina = pagina -1;
							mostra(ricA,pagina);
						}
					}
				}else
				{
					if(pagina!=1)
					{
						if(ricU!=null)
						{
						pagina = pagina -1;
						mostraUtente(ricU,pagina);
						}
					}
				}
			}
		});
		btnNewButton_2.setBounds(926, 47, 75, 25);
		btnNewButton_2.setText("Indietro");
		
		
		Combo combo = new Combo(shell, SWT.NONE);
		combo.setItems(new String[] {"Sport", "Motori", "Arredo", "Abbigliamento", "Tecnologia"});
		combo.setBounds(1480, 160, 104, 23);
		combo.setText("Categoria");
		
		
		txtRicercaPerEmail = new Text(shell, SWT.BORDER);
		txtRicercaPerEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.character == 13)
				{
					if(txtRicercaPerEmail.getText().equals(""))
					{
						Home hh= new Home();
						shell.close();
						hh.open();
					}else
					{
						HomeNonAutenticataController nonContr= new HomeNonAutenticataController();
						if(!btnCheckButton.getSelection())
						{
						ricA= nonContr.ricercaPerAste(txtRicercaPerEmail.getText());
						pagina =1;
						count=ricA.size();
						Home hh = new Home();
						hh.setRicA(ricA);
						hh.setStoRicercando(true);
						shell.close();
						hh.open();
						}else
						{
							
							ricU =nonContr.ricercaPerUtenti(txtRicercaPerEmail.getText());
							pagina =1;
							mostraUtente(ricU,pagina);
						}
					}
				}
			}
		
		});
		txtRicercaPerEmail.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		txtRicercaPerEmail.setBounds(480, 159, 895, 23);
		
		Label label_1_1_1 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1_1_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		label_1_1_1.setBounds(-6, 662, 384, 2);
		
		Label label_1_1_2 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1_1_2.setBackground(SWTResourceManager.getColor(255, 215, 0));
		label_1_1_2.setBounds(-6, 801, 384, 2);
		
		Label label_1_1_3 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1_1_3.setBackground(SWTResourceManager.getColor(255, 215, 0));
		label_1_1_3.setBounds(-6, 940, 384, 2);
		
		Label lblNewLabel_1_1_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shell.close();
				Profilo p= new Profilo();
				p.open();
			}
		});
		lblNewLabel_1_1_1.setText("Profilo");
		lblNewLabel_1_1_1.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.BOLD));
		lblNewLabel_1_1_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_1_1_1.setBounds(153, 577, 93, 37);
		
		Label lblNewLabel_1_1_1_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				Wallet w= new Wallet();
				shell.close();
				w.open();
			}
		});
		lblNewLabel_1_1_1_1.setText("Wallet");
		lblNewLabel_1_1_1_1.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.BOLD));
		lblNewLabel_1_1_1_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_1_1_1_1.setBounds(153, 716, 93, 37);
		
		Label lblNewLabel_1_1_1_2 = new Label(shell, SWT.NONE);
		lblNewLabel_1_1_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				GestAsta ga = new GestAsta();
				shell.close();
				ga.open();
			}
		});
		lblNewLabel_1_1_1_2.setText("Gestione Asta");
		lblNewLabel_1_1_1_2.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.BOLD));
		lblNewLabel_1_1_1_2.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_1_1_1_2.setBounds(108, 855, 182, 37);
		pag.add(pagina);
		
		Label saldo = new Label(shell, SWT.BORDER);
		saldo.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
		saldo.setBounds(1680, 10, 217, 37);
		saldo.setText("Il mio saldo "+DbMock.getCurrentUser().getWallet().getSaldo()+"");
		saldo.setBackground(SWTResourceManager.getColor(230, 230, 250));
		
		Label text = new Label(shell, SWT.READ_ONLY);
		text.setBackground(SWTResourceManager.getColor(255, 215, 0));
		text.setText(" Ricerca Asta (default) o Utente (NomeUtente)");
		text.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		text.setBounds(480, 125, 895, 23);
		
		Button btnNewButton_3 = new Button(shell, SWT.NONE);
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				PaginaPrincipalenon pp= new PaginaPrincipalenon();
				shell.close();
				pp.open();
			}
		});
		btnNewButton_3.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		btnNewButton_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		btnNewButton_3.setBounds(1570, 10, 104, 37);
		btnNewButton_3.setText("Logout");
		pag.add(pagina);
		/*if(!(toOpen ==null))
			toOpen.open();*/
		/*Thread timeThread = new Thread() {
            public void run() {
                while (true) {
                    display.syncExec(new Runnable() {

                        @Override
                        public void run() {
                        	lblNewLabel_2.setText(Calendar.getInstance().getTime().toString());
                        }
                    });

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        timeThread.setDaemon(true);
        timeThread.start();*/
	}
	public void mostra(List<Asta> aste,int pp,Group g, Label l1 , Button b1, Label l2, Composite c)
	{
		g.setBackground(SWTResourceManager.getColor(255, 215, 0));
		g.setBounds(480, 200, 1104, 1000);
		for(int i=0;i<4;i++)
		{
			
			if((pp-1)*4+i<aste.size())
			{
				if(((pagina-1)*4+i)==aste.size()-1)
				{
					check=false;
				}
				Asta a=aste.get((pp-1)*4+i);
				Label lblAsta = new Label(g, SWT.H_SCROLL | SWT.V_SCROLL);
				lblAsta.setFont(SWTResourceManager.getFont("Segoe UI", 18, SWT.BOLD));
				lblAsta.setBackground(SWTResourceManager.getColor(255, 215, 0));
				lblAsta.setBounds(30, 83+i*200, 500, 32);
				lblAsta.setText(a.getTitoloAsta());
				titoli.add(lblAsta);
				
				Button btnNewButton = new Button(g, SWT.PUSH);
				btnNewButton.setFont(SWTResourceManager.getFont("Segoe UI", 8, SWT.NORMAL));
				btnNewButton.setBounds(743, 83+i*200, 80, 32);
				bottoni.add(btnNewButton);
				btnNewButton.setText("Visualizza");
				btnNewButton.addMouseListener(ma= new MouseAdapter() {
					@Override
					public void mouseUp(MouseEvent e) {
						if(pp==pagina)
						{
							if(!ricerca)
							{
								VediAsta va= new VediAsta();
								va.setInHome(true);
								va.setChiSono(shell);
								if(a.getVenditore().equals(DbMock.getCurrentUser().getEmail()))
									va.setOffri(false);
								va.setNomeAsta(a.getTitoloAsta());
								va.open();
							}else
							{
								if(current.size()<=count)
								current.get(count-1).open();
							}
						}
					}
				});
				//btnNewButton.addM
				Label lblTitoloAsta = new Label(g, SWT.H_SCROLL | SWT.V_SCROLL);
				lblTitoloAsta.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
				lblTitoloAsta.setBackground(SWTResourceManager.getColor(255, 215, 0));
				lblTitoloAsta.setBounds(30, 138+i*200, 750, 65);
				descrizioni.add(lblTitoloAsta);
				lblTitoloAsta.setText("Descrizione: " +a.getDescrizioneAsta()+"\nCategoria: " +a.getProdotto().getCategoria());
				
				Composite composite = new Composite(g, SWT.NONE);
				composite.setBounds(875, 83+i*200, 150, 150);
				if(!a.getProdotto().getImmagine().equals(""))
				composite.setBackgroundImage(new Image(display,a.getProdotto().getImmagine()));
				quadrati.add(composite);
			
			}
		}
		
	}

		public void mostra(List<Asta> aste, int pp)
		{
			current=new ArrayList<VediAsta>();
		boolean creami=false;
		for(Integer inter: pag)
		{
			if(inter==pp)
			{
				 creami = true;
			}
		}
		if(!creami)
		pag.add(pp);
			for(int i=0;i<4;i++)
			{
				Label l1= titoli.get(i);
				VediAsta va=new VediAsta();
				Label l2= descrizioni.get(i);
				Button b = bottoni.get(i);
				Composite c = quadrati.get(i);
				
				if((pagina-1)*4+i<aste.size())
				{
					check= true;
					Asta a= aste.get((pagina-1)*4+i);
					va.setNomeAsta(a.getTitoloAsta());
					l1.setText(a.getTitoloAsta());
					l2.setText("Descrizione: " +a.getDescrizioneAsta()+"\nCategoria: " +a.getProdotto().getCategoria());
					b.setVisible(true);
					c.setVisible(true);
					b.setText("Visualizza");
					if(!a.getProdotto().getImmagine().equals(""))
					c.setBackgroundImage(new Image(display,a.getProdotto().getImmagine()));
					if(!creami || ricerca)
					{
					b.addMouseListener(ma= new MouseAdapter() {
						@Override
						public void mouseUp(MouseEvent e) {
							if(pp==pagina)
							{
								if(a.getVenditore().equals(DbMock.getCurrentUser().getEmail()))
									va.setOffri(false);
								va.setChiSono(shell);
								va.open();
							}
						}
					});
					
					}
					if(((pagina-1)*4+i)==aste.size()-1)
					{
						check=false;
					}
					current.add(va);
				}else
				{
					check=false;
					l1.setText("");
					l2.setText("");
					b.setVisible(false);
					c.setVisible(false);
				}
			}
			
			if(ricerca==true)
				ricerca=false;
		}
		public void mostraUtente(List<Utente> utenti, int pagina)
		{
			for(int i=0;i<4;i++)
			{
				Label l1= titoli.get(i);
				Label l2= descrizioni.get(i);
				Button b = bottoni.get(i);
				Composite c = quadrati.get(i);
				if((pagina-1)*4+i<utenti.size())
				{
					check= true;
					Utente a= utenti.get((pagina-1)*4+i);
					l1.setText(a.getNomeProfilo());
					l2.setText(a.getDescrizione());
					b.setVisible(false);
					c.setVisible(true);
					b.setText("Visualizza");
					
					if(!a.getImmagineProfilo().equals(""))
					c.setBackgroundImage(new Image(display,a.getImmagineProfilo()));
					if(((pagina-1)*4+i)==utenti.size()-1)
					{
						check=false;
					}
				}else
				{
					check=false;
					l1.setText("");
					l2.setText("");
					b.setVisible(false);
					c.setVisible(false);
				}
			}
		}

	public Shell getToOpen() {
		return toOpen;
	}

	public void setToOpen(Shell toOpen) {
		this.toOpen = toOpen;
	}

	public List<Asta> getRicA() {
		return ricA;
	}

	public void setRicA(List<Asta> ricA) {
		this.ricA = ricA;
	}

	public boolean isStoRicercando() {
		return stoRicercando;
	}

	public void setStoRicercando(boolean stoRicercando) {
		this.stoRicercando = stoRicercando;
	}
}
