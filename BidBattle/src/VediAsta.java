import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import model.Asta;
import model.DbMock;
import model.Utente;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Combo;

import java.time.Duration;
import java.time.LocalDateTime;

import javax.swing.JFileChooser;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Image;

public class VediAsta {

	protected Shell shell;
	private Shell chiSono;
	private String nomeAsta;
	DbMock db= new DbMock();
	private boolean inHome= true;
	private boolean offri= true;
	Display display = Display.getDefault();
	private Boolean thread = true;
	Thread timeThread;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			VediAsta window = new VediAsta();
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
		shell.addListener(SWT.Close, new Listener() {
		      public void handleEvent(Event event) {
		        thread = false;
		      }
		    });
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
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(255, 215, 0));
		shell.setSize(670, 688);
		shell.setText("Asta");
		shell.setLayout(null);
		Asta a= DbMock.getAstabyTitolo(this.getNomeAsta());
		Group grpProdotto = new Group(shell, SWT.SHADOW_ETCHED_IN);
		grpProdotto.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		grpProdotto.setBackground(SWTResourceManager.getColor(255, 215, 0));
		grpProdotto.setBounds(83, 166, 481, 255);
		grpProdotto.setText("Prodotto");
		
		Label lblNewLabel_2 = new Label(grpProdotto, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblNewLabel_2.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_2.setBounds(10, 43, 55, 15);
		lblNewLabel_2.setText("Titolo:");
		
		Label lblNewLabel_3 = new Label(grpProdotto, SWT.NONE);
		lblNewLabel_3.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblNewLabel_3.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_3.setBounds(10, 91, 94, 15);
		lblNewLabel_3.setText("Descrizione:");
		
		Label lblCategoria = new Label(grpProdotto, SWT.NONE);
		lblCategoria.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblCategoria.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblCategoria.setBounds(10, 142, 55, 15);
		lblCategoria.setText("Categoria:");
		
		Label lblImmagine = new Label(grpProdotto, SWT.NONE);
		lblImmagine.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblImmagine.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblImmagine.setBounds(292, 43, 55, 15);
		lblImmagine.setText("Immagine");
		
		Composite group = new Composite(grpProdotto, SWT.NONE);
		group.setBackground(SWTResourceManager.getColor(240, 255, 255));
		group.setBounds(292, 71, 150, 150);
		group.setBackgroundImage(new Image(display,a.getProdotto().getImmagine()));
		
		Label lblNewLabel_6 = new Label(grpProdotto, SWT.NONE);
		lblNewLabel_6.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_6.setBounds(10, 66, 118, 15);
		System.out.println(a.toString());
		lblNewLabel_6.setText(a.getProdotto().getTitolo());
		
		Label lblNewLabel_6_1 = new Label(grpProdotto, SWT.NONE);
		lblNewLabel_6_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_6_1.setText(a.getProdotto().getCategoria());
		lblNewLabel_6_1.setBounds(10, 165, 118, 15);
		
		Label lblNewLabel_9 = new Label(grpProdotto, SWT.NONE);
		lblNewLabel_9.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_9.setBounds(10, 115, 206, 30);
		lblNewLabel_9.setText(a.getProdotto().getDescrizione());
		
		Label lblProprietario = new Label(grpProdotto, SWT.NONE);
		lblProprietario.setText("Proprietario:");
		lblProprietario.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblProprietario.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblProprietario.setBounds(10, 186, 94, 15);
		
		Label lblNewLabel_6_1_1 = new Label(grpProdotto, SWT.NONE);
		lblNewLabel_6_1_1.setText(DbMock.getUtente(a.getVenditore()).getNomeProfilo());
		lblNewLabel_6_1_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_6_1_1.setBounds(10, 207, 118, 15);
		
		Label lblNewLabel_4 = new Label(shell, SWT.NONE);
		lblNewLabel_4.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblNewLabel_4.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_4.setBounds(83, 426, 95, 15);
		lblNewLabel_4.setText("Prezzo attuale");
		
		Label lblTermineAsta = new Label(shell, SWT.NONE);
		lblTermineAsta.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblTermineAsta.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblTermineAsta.setBounds(83, 472, 117, 15);
		lblTermineAsta.setText("Termine asta");
		Button btnCreaAsta = new Button(shell, SWT.NONE);
		btnCreaAsta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				FaiOfferta off= new FaiOfferta();
				off.setInHome(inHome);
				off.setChiSono(chiSono);
				off.setNomeAsta(a.getTitoloAsta());
				off.setP(shell);
				off.open();
			}
		});
		btnCreaAsta.setBounds(83, 535, 75, 25);
		btnCreaAsta.setText("Offri");
		
		
		if(!offri)
			btnCreaAsta.setVisible(false);
		
		if(DbMock.isOver(a))
			btnCreaAsta.setVisible(false);
		Label lblOffertaScontantaPallone = new Label(shell, SWT.NONE);
		lblOffertaScontantaPallone.setForeground(SWTResourceManager.getColor(0, 0, 0));
		lblOffertaScontantaPallone.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		lblOffertaScontantaPallone.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblOffertaScontantaPallone.setBounds(196, 82, 388, 39);
		lblOffertaScontantaPallone.setText(a.getTitoloAsta());
		
		Label lblNewLabel_5 = new Label(shell, SWT.NONE);
		lblNewLabel_5.setToolTipText("");
		lblNewLabel_5.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_5.setBounds(84, 127, 376, 15);
		lblNewLabel_5.setText(a.getDescrizioneAsta());
		
		Label lblNewLabel_7 = new Label(shell, SWT.NONE);
		lblNewLabel_7.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_7.setBounds(83, 448, 258, 15);
		if(a.getOfferteInCorso().size()>0)
		lblNewLabel_7.setText(""+a.getOfferteInCorso().get(a.getOfferteInCorso().size()-1).getPrezzo()+" €");
		else
			lblNewLabel_7.setText(""+a.getPrezzoIniziale());
		Label lblNewLabel_8 = new Label(shell, SWT.NONE);
		lblNewLabel_8.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_8.setBounds(83, 495, 329, 15);
		
		Label lblNewLabel_4_1 = new Label(shell, SWT.NONE);
		lblNewLabel_4_1.setText("Ultimo Offerente");
		lblNewLabel_4_1.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblNewLabel_4_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_4_1.setBounds(365, 427, 133, 15);
		
		Label lblNewLabel_7_1 = new Label(shell, SWT.NONE);
		if(!a.getOfferteInCorso().isEmpty())
		lblNewLabel_7_1.setText(DbMock.getUtente(a.getOfferteInCorso().get(a.getOfferteInCorso().size()-1).getUtente()).getNomeProfilo());
		else
			lblNewLabel_7_1.setText("Nessun Offerente");
		lblNewLabel_7_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_7_1.setBounds(365, 448, 258, 15);
		thread=true;
		 timeThread = new Thread() {
	        public void run() {
	            while (thread) {
	                display.syncExec(new Runnable() {

	                    @Override
	                    public void run() {
	                    	//private String tempo= a.getDurataAsta().minus(LocalDateTime.now());
	            
	                    	Duration d = Duration.between(a.getDurataAsta(), LocalDateTime.now());
	                    	int oreFine = d.toHoursPart();
	                    	long GiorniFine = d.toDaysPart();
	                    	int minutiFine = d.toMinutesPart();
	                    	int secondFine = d.toSecondsPart();
	                    	//lblTitoloAsta.setText("Descrizione: " +a.getDescrizioneAsta()+"\nCategoria: " +a.getProdotto().getCategoria()+"\n"+"Termina tra: "+d);
	                    	if(thread)
	                    		lblNewLabel_8.setText("Termina tra: "+Math.abs(GiorniFine)+"gg"+" "+ Math.abs(oreFine) +":"+Math.abs(minutiFine)+":"+Math.abs(secondFine));
	                    
	                    	if((Math.abs(GiorniFine)==0 && Math.abs(minutiFine)<=0 && Math.abs(secondFine)<=0) || LocalDateTime.now().isAfter(a.getDurataAsta()))
	                    	{
	                    		DbMock.getAsteDaMostare().remove(a);
	                    		lblNewLabel_8.setText("Asta terminata");
	                    		btnCreaAsta.setVisible(false);
	                    		DbMock.getAsteTerminate().add(a);
	                    	
	                    		//DbMock.getAs
	                    		DbMock.getUtente(a.getOfferteInCorso().get(a.getOfferteInCorso().size()-1).getUtente()).getAsteVinte().add(a);
	                    		thread=false;
	                    	}
	                    	//lblTitoloAsta.setText("Descrizione: " +a.getDescrizioneAsta()+"\nCategoria: " +a.getProdotto().getCategoria()+"\n"+Calendar.getInstance().getTime().toString());
	                    }
	                });

	                try {
	                    Thread.sleep(1000);
	                } catch (InterruptedException e) {
	                	 timeThread.stop();
	    	        }
	                
	            }
	            timeThread.stop();
	        }
	    };

	    timeThread.setDaemon(true);
	    timeThread.start();
	    
	}
	    


	public boolean isInHome() {
		return inHome;
	}

	public void setInHome(boolean inHome) {
		this.inHome = inHome;
	}

	public String getNomeAsta() {
		return nomeAsta;
	}

	public void setNomeAsta(String nomeAsta) {
		this.nomeAsta = nomeAsta;
	}

	public boolean isOffri() {
		return offri;
	}

	public void setOffri(boolean offri) {
		this.offri = offri;
	}

	public Shell getChiSono() {
		return chiSono;
	}

	public void setChiSono(Shell chiSono) {
		this.chiSono = chiSono;
	}
	
}

