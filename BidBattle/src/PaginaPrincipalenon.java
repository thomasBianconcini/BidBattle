import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import controller.HomeNonAutenticataController;
import model.Asta;
import model.DbMock;
import model.Utente;

import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.ExpandBar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JScrollPane;

import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import java.util.function.Consumer;

public class PaginaPrincipalenon {

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
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			PaginaPrincipalenon window = new PaginaPrincipalenon();
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
		shell.setText("PaginaPrincipaleNonAutenticata");
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
		label_1_1.setBounds(-11, 614, 384, 2);
		
		Label label_2 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_2.setBackground(SWTResourceManager.getColor(255, 215, 0));
		label_2.setBounds(-11, 844,p.x*20/100, 2);
		
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
				pagina=1;
				mostra(aste,pagina);
			}
		});
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.NORMAL));
		lblNewLabel.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel.setBounds(153, 480, 78, 37);
		lblNewLabel.setText("Home");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				Login l= new Login();
				l.setShellNon(shell);
				l.open();
			}
		});
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.NORMAL));
		lblNewLabel_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_1.setText("Login");
		lblNewLabel_1.setBounds(153, 710, 78, 37);
		
		Label lblNewLabel_1_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				Registrazione registrazione= new Registrazione();
				registrazione.setShellNon(shell);
				registrazione.open();
			}
		});
		lblNewLabel_1_1.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.NORMAL));
		lblNewLabel_1_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_1_1.setText("Registrazione");
		lblNewLabel_1_1.setBounds(108, 940, 167, 37);
		
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
		
		mostra(aste,pagina,grpLeMieAste,lblAsta,btnNewButton,lblTitoloAsta,composite);
		Button btnNewButton_1 = new Button(grpLeMieAste, SWT.NONE);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if(!btnCheckButton.getSelection())
				{
					if(check)
					{
						if(ricA==null)
						{
						pagina = pagina +1;
						mostra(aste,pagina);
						}
						else
						{
							pagina = pagina +1;
							mostra(aste,pagina);
						}
					}
				}else
				{
					if(check)
					{
						if(ricU!=null)
						{
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
						if(ricA==null)
						{
						pagina = pagina -1;
						mostra(aste,pagina);
						}
						else
						{
							pagina = pagina -1;
							mostra(aste,pagina);
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
						pagina=1;
						mostra(aste,pagina);
					}else
					{
						HomeNonAutenticataController nonContr= new HomeNonAutenticataController();
						if(!btnCheckButton.getSelection())
						{
						ricA= nonContr.ricercaPerAste(txtRicercaPerEmail.getText());
						pagina =1;
						count=ricA.size();
						mostra(ricA,pagina);
						ricerca=true;
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
		txtRicercaPerEmail.setText(" Ricerca Asta (default) o Utente (NomeUtente)");
		txtRicercaPerEmail.setBounds(480, 154, 895, 23);
		pag.add(pagina);
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
		ricA=null;
		ricU=null;
		for(int i=0;i<4;i++)
		{
			
			if((pp-1)*4+i<DbMock.getAsteDaMostare().size())
			{
				Asta a=aste.get((pp-1)*4+i);
				Label lblAsta = new Label(g, SWT.H_SCROLL | SWT.V_SCROLL);
				lblAsta.setFont(SWTResourceManager.getFont("Segoe UI", 18, SWT.NORMAL));
				lblAsta.setBackground(SWTResourceManager.getColor(255, 215, 0));
				lblAsta.setBounds(30, 83+i*200, 166, 32);
				lblAsta.setText(a.getTitoloAsta());
				titoli.add(lblAsta);
				System.out.println(a.getTitoloAsta());
				
				Button btnNewButton = new Button(g, SWT.PUSH);
				btnNewButton.setFont(SWTResourceManager.getFont("Segoe UI", 6, SWT.NORMAL));
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
								va.setNomeAsta(a.getTitoloAsta());
								va.open();
							}else
							{
								System.out.println(current.size());
								System.out.println(current.get(0).getNomeAsta());
								System.out.println(count);
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
				lblTitoloAsta.setBounds(30, 138+i*200, 599, 30);
				descrizioni.add(lblTitoloAsta);
				lblTitoloAsta.setText("Descrizione " +a.getDescrizioneAsta()+", Categoria :" +a.getProdotto().getCategoria());
				
				Composite composite = new Composite(g, SWT.NONE);
				composite.setBounds(875, 83+i*200, 150, 150);
				quadrati.add(composite);
			
			}
		}
		
	}
		
	/*public void mostra(List<Asta> aste, int pp)
		{
			for(int i=0;i<4;i++)
			{
				Label l1= titoli.get(i);
				Label l2= descrizioni.get(i);
				Button b = bottoni.get(i);
				Composite c = quadrati.get(i);
				if((pagina-1)*4+i<aste.size())
				{
					check= true;
					Asta a= aste.get((pagina-1)*4+i);
					l1.setText(a.getTitoloAsta());
					l2.setText(a.getTitoloAsta());
					b.setVisible(true);
					c.setVisible(true);
					b.setText("Visualizza");
					b.addMouseListener(ma= new MouseAdapter() {
						@Override
						public void mouseUp(MouseEvent e) {
							if(pp==pagina)
							{
							VediAsta va= new VediAsta();
							va.setNomeAsta(a.getTitoloAsta());
							va.open();
							}
						}
					});
					if(((pagina-1)*4+i)==aste.size()-1)
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
	*/
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
					l2.setText(a.getTitoloAsta());
					b.setVisible(true);
					c.setVisible(true);
					b.setText("Visualizza");
					if(!creami || ricerca)
					{
					b.addMouseListener(ma= new MouseAdapter() {
						@Override
						public void mouseUp(MouseEvent e) {
							if(pp==pagina)
							{
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
				b.setVisible(true);
				c.setVisible(true);
				b.setText("Visualizza");
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
}
