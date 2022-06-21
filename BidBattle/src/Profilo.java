import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import controller.HomeNonAutenticataController;
import model.Asta;
import model.DbMock;
import model.Utente;

import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.dnd.DND;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Profilo {

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
			Profilo window = new Profilo();
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
		lblNewLabel_1_1_1.setBounds(153, 577, 122, 37);
		
		Label lblNewLabel_1_1_1_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1_1_1_1.setText("Wallet");
		lblNewLabel_1_1_1_1.setFont(SWTResourceManager.getFont("Segoe UI", 20, SWT.BOLD));
		lblNewLabel_1_1_1_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_1_1_1_1.setBounds(153, 716, 101, 37);
		lblNewLabel_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				Wallet w= new Wallet();
				shell.close();
				w.open();
			}
		});
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
		
		Label lblNomeutente = new Label(shell, SWT.NONE);
		lblNomeutente.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNomeutente.setFont(SWTResourceManager.getFont("Segoe UI", 25, SWT.BOLD));
		lblNomeutente.setBounds(882, 123, 300, 56);
		if(DbMock.getCurrentUser().getNomeProfilo()==null)
		{
			lblNomeutente.setText("NomeProfilo");
		}else
		lblNomeutente.setText(DbMock.getCurrentUser().getNomeProfilo());
		
		
		Composite composite_1 = formToolkit.createComposite(shell, SWT.NONE);
		composite_1.setBounds(480, 220, 150, 150);
		formToolkit.paintBordersFor(composite_1);
		composite_1.setBackgroundImage(new Image(display,DbMock.getCurrentUser().getImmagineProfilo()));
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblNewLabel_1.setForeground(SWTResourceManager.getColor(220, 220, 220));
		lblNewLabel_1.setBackground(SWTResourceManager.getColor(211, 211, 211));
		lblNewLabel_1.setBounds(667, 220, 917, 150);
		if(DbMock.getCurrentUser().getDescrizione()==null)
		{
			lblNewLabel_1.setText("Descrizione");
		}else
		lblNewLabel_1.setText(DbMock.getCurrentUser().getDescrizione());
		formToolkit.adapt(lblNewLabel_1, true, true);
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
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		lblNewLabel_2.setBounds(493, 488, 200, 37);
		formToolkit.adapt(lblNewLabel_2, true, true);
		lblNewLabel_2.setText("Email:");
		lblNewLabel_2.setBackground(SWTResourceManager.getColor(255, 215, 0));
		Label lblNewLabel_2_1 = new Label(shell, SWT.NONE);
		if(DbMock.getCurrentUser().getEmail()==null)
		{
			lblNewLabel_2_1.setText("Email");
		}else
		lblNewLabel_2_1.setText(DbMock.getCurrentUser().getEmail());
		lblNewLabel_2_1.setBounds(1225, 488, 359, 37);
		formToolkit.adapt(lblNewLabel_2_1, true, true);
		lblNewLabel_2_1.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
		Label lblNewLabel_2_1_1 = new Label(shell, SWT.NONE);
		lblNewLabel_2_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_2_1_1.setText("*********");
		lblNewLabel_2_1_1.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
		lblNewLabel_2_1_1.setBounds(1225, 588, 359, 37);
		formToolkit.adapt(lblNewLabel_2_1_1, true, true);
		lblNewLabel_2_1_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		
		Label lblNewLabel_2_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2_2.setText("Password:");
		lblNewLabel_2_2.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		lblNewLabel_2_2.setBounds(490, 584, 190, 37);
		formToolkit.adapt(lblNewLabel_2_2, true, true);
		lblNewLabel_2_2.setBackground(SWTResourceManager.getColor(255, 215, 0));
		
		Label lblNewLabel_2_1_3 = new Label(shell, SWT.NONE);
		if(DbMock.getCurrentUser().getIndirizzo()==null)
		{
			lblNewLabel_2_1_3.setText("Indirizzo");
		}else
		lblNewLabel_2_1_3.setText(DbMock.getCurrentUser().getIndirizzo());
		lblNewLabel_2_1_3.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
		lblNewLabel_2_1_3.setBounds(1225, 688, 359, 37);
		formToolkit.adapt(lblNewLabel_2_1_3, true, true);
		lblNewLabel_2_1_3.setBackground(SWTResourceManager.getColor(255, 215, 0));
		
		Label lblNewLabel_2_4 = new Label(shell, SWT.NONE);
		lblNewLabel_2_4.setText("Indirizzo:");
		lblNewLabel_2_4.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		lblNewLabel_2_4.setBounds(493, 688, 200, 37);
		formToolkit.adapt(lblNewLabel_2_4, true, true);
		lblNewLabel_2_4.setBackground(SWTResourceManager.getColor(255, 215, 0));
		
		Button btnNewButton_1 = formToolkit.createButton(shell, "Modifica Dati", SWT.NONE);
		btnNewButton_1.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				Modificadati m= new Modificadati();
				m.setShellProfilo(shell);
				m.open();
			}
		});
		btnNewButton_1.setBounds(1658, 220, 110, 37);
		pag.add(pagina);
		
		Label saldo = new Label(shell, SWT.BORDER);
		saldo.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
		saldo.setBounds(1680, 10, 217, 37);
		formToolkit.adapt(saldo, true, true);
		saldo.setText("Il mio saldo "+DbMock.getCurrentUser().getWallet().getSaldo()+"");
		saldo.setBackground(SWTResourceManager.getColor(230, 230, 250));
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
}

