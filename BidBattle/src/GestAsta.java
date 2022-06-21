import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.Label;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.wb.swt.SWTResourceManager;

import model.Asta;
import model.DbMock;
import model.Utente;

import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class GestAsta {

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
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			GestAsta window = new GestAsta();
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
		Label saldo = new Label(shell, SWT.BORDER);
		saldo.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
		saldo.setBounds(1680, 10, 217, 37);
		formToolkit.adapt(saldo, true, true);
		saldo.setText("Il mio saldo "+DbMock.getCurrentUser().getWallet().getSaldo()+"");
		saldo.setBackground(SWTResourceManager.getColor(230, 230, 250));
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
		label_1_1.setBounds(-11, 523, 384, 2);
		
		Label label_2 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_2.setBackground(SWTResourceManager.getColor(255, 215, 0));
		label_2.setBounds(-11, 1080,p.x*20/100, 2);
		
		Label label_1_2 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1_2.setBackground(SWTResourceManager.getColor(255, 215, 0));
		label_1_2.setBounds(-11, 1078, p.x*20/100, 10);
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				Home h= new Home();
				shell.close();
				h.open();
			}
		});
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.BOLD));
		lblNewLabel.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel.setBounds(153, 438, 91, 37);
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
		Label lblAsta=null;
		Button btnNewButton = null;
		Label lblTitoloAsta = null;
		
	
		
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
		lblNewLabel_1_1_1.setBounds(153, 577, 105, 37);
		
		Label lblNewLabel_1_1_1_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1_1_1_1.setText("Wallet");
		lblNewLabel_1_1_1_1.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.BOLD));
		lblNewLabel_1_1_1_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_1_1_1_1.setBounds(153, 716, 116, 37);
		lblNewLabel_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				Wallet w= new Wallet();
				shell.close();
				w.open();
			}
		});
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
		Label lblNewLabel_1_1_1_2 = new Label(shell, SWT.NONE);
		lblNewLabel_1_1_1_2.setText("Gestione Asta");
		lblNewLabel_1_1_1_2.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.BOLD));
		lblNewLabel_1_1_1_2.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_1_1_1_2.setBounds(108, 855, 209, 37);
		
		Label lblNomeutente = new Label(shell, SWT.NONE);
		lblNomeutente.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNomeutente.setFont(SWTResourceManager.getFont("Segoe UI", 25, SWT.BOLD));
		lblNomeutente.setBounds(882, 123, 300, 37);
		lblNomeutente.setText("Gestione Asta");
		Group grpLeMieAste = new Group(shell, SWT.BORDER);
		grpLeMieAste.setBackground(SWTResourceManager.getColor(255, 215, 0));
		grpLeMieAste.setBounds(480, 200, 1104, 1000);
	
		
		Button btnNewButton_1 = formToolkit.createButton(shell, "Crea Asta", SWT.NONE);
		btnNewButton_1.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				CreaAsta ca = new CreaAsta();
				ca.setShellGestioneAsta(shell);
				ca.open();
			}
		});
		btnNewButton_1.setBounds(1693, 220, 99, 48);
		pag.add(pagina);
		//List<Asta> list = DbMock.getAsteDaMostare();
		List<Asta> list = DbMock.getCurrentUser().getAstePersonali();
		mostra(list,pagina,grpLeMieAste,lblAsta,btnNewButton,lblTitoloAsta);
		Button btnNewButton_11 = new Button(grpLeMieAste, SWT.NONE);
		btnNewButton_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
					if(check)
					{
						pagina = pagina +1;
						mostra(list,pagina);
						
					}
			}
		});
		btnNewButton_11.setBounds(1007, 47, 75, 25);
		btnNewButton_11.setText("Avanti");
		
		Button btnNewButton_2 = new Button(grpLeMieAste, SWT.NONE);
	
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				
					if(pagina!=1)
					{
						pagina = pagina -1;
						mostra(list,pagina);
						
					}
			}
		});
		btnNewButton_2.setBounds(926, 47, 75, 25);
		btnNewButton_2.setText("Indietro");
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
	public void mostra(List<Asta> aste,int pp,Group g, Label l1 , Button b1, Label l2)
	{
		g.setBackground(SWTResourceManager.getColor(255, 215, 0));
		g.setBounds(480, 200, 1104, 1000);
		ricA=null;
		ricU=null;
		if(aste.size()>0)
		{
		for(int i=0;i<4;i++)
		{
			
			if((pp-1)*4+i<aste.size())
			{
				Asta a=aste.get((pp-1)*4+i);
				Label lblAsta = new Label(g, SWT.H_SCROLL | SWT.V_SCROLL);
				lblAsta.setFont(SWTResourceManager.getFont("Segoe UI", 18, SWT.BOLD));
				lblAsta.setBackground(SWTResourceManager.getColor(255, 215, 0));
				lblAsta.setBounds(30, 83+i*200, 500,40);
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
								VediAsta va= new VediAsta();
								va.setOffri(false);
								va.setNomeAsta(a.getTitoloAsta());
								va.open();
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
				quadrati.add(composite);
				if(!a.getProdotto().getImmagine().equals(""))
					composite.setBackgroundImage(new Image(display,a.getProdotto().getImmagine()));
			
			}
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
				if(!creami)
				{
				b.addMouseListener(ma= new MouseAdapter() {
					@Override
					public void mouseUp(MouseEvent e) {
						if(pp==pagina)
						{
							va.setOffri(false);
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
		
	}
}
