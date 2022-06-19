import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import model.Asta;
import model.DbMock;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Combo;
import javax.swing.JFileChooser;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class VediAsta {

	protected Shell shell;
	private String nomeAsta;
	DbMock db= new DbMock();
	private boolean inHome= true;
	private boolean offri= true;
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
		Display display = Display.getDefault();
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
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(255, 215, 0));
		shell.setSize(778, 688);
		shell.setText("SWT Application");
		shell.setLayout(null);
		Asta a= DbMock.getAstabyTitolo(this.getNomeAsta());
		Group grpProdotto = new Group(shell, SWT.SHADOW_ETCHED_IN);
		grpProdotto.setBackground(SWTResourceManager.getColor(255, 215, 0));
		grpProdotto.setBounds(189, 170, 481, 255);
		grpProdotto.setText("Prodotto");
		
		Label lblNewLabel_2 = new Label(grpProdotto, SWT.NONE);
		lblNewLabel_2.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_2.setBounds(10, 43, 55, 15);
		lblNewLabel_2.setText("Titolo");
		
		Label lblNewLabel_3 = new Label(grpProdotto, SWT.NONE);
		lblNewLabel_3.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_3.setBounds(10, 91, 94, 15);
		lblNewLabel_3.setText("Descrizione");
		
		Label lblCategoria = new Label(grpProdotto, SWT.NONE);
		lblCategoria.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblCategoria.setBounds(10, 142, 55, 15);
		lblCategoria.setText("Categoria");
		
		Label lblImmagine = new Label(grpProdotto, SWT.NONE);
		lblImmagine.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblImmagine.setBounds(230, 43, 55, 15);
		lblImmagine.setText("Immagine");
		
		Group group = new Group(grpProdotto, SWT.NONE);
		group.setBackground(SWTResourceManager.getColor(240, 255, 255));
		group.setBounds(230, 64, 241, 181);
		
		DropTarget dropTarget = new DropTarget(group, DND.DROP_MOVE);
		
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
		
		Label lblNewLabel_4 = new Label(shell, SWT.NONE);
		lblNewLabel_4.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_4.setBounds(189, 430, 95, 15);
		lblNewLabel_4.setText("Prezzo attuale");
		
		Label lblTermineAsta = new Label(shell, SWT.NONE);
		lblTermineAsta.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblTermineAsta.setBounds(189, 476, 66, 15);
		lblTermineAsta.setText("Termine asta");
		Button btnCreaAsta = new Button(shell, SWT.NONE);
		btnCreaAsta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				FaiOfferta off= new FaiOfferta();
				off.setInHome(inHome);
				off.setNomeAsta(a.getTitoloAsta());
				off.setP(shell);
				off.open();
			}
		});
		btnCreaAsta.setBounds(189, 539, 75, 25);
		btnCreaAsta.setText("Offri");
		

		System.out.print("Vedi asta "+ offri  + " tttt " + a.getTitoloAsta()); 
		
		if(!offri)
			btnCreaAsta.setVisible(false);
		
		if(DbMock.isOver(a))
			btnCreaAsta.setVisible(false);
		Label lblOffertaScontantaPallone = new Label(shell, SWT.NONE);
		lblOffertaScontantaPallone.setForeground(SWTResourceManager.getColor(0, 0, 0));
		lblOffertaScontantaPallone.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
		lblOffertaScontantaPallone.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblOffertaScontantaPallone.setBounds(302, 86, 228, 39);
		lblOffertaScontantaPallone.setText(a.getTitoloAsta());
		
		Label lblNewLabel_5 = new Label(shell, SWT.NONE);
		lblNewLabel_5.setToolTipText("");
		lblNewLabel_5.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_5.setBounds(189, 146, 376, 15);
		lblNewLabel_5.setText(a.getDescrizioneAsta());
		
		Label lblNewLabel_7 = new Label(shell, SWT.NONE);
		lblNewLabel_7.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_7.setBounds(189, 452, 258, 15);
		if(a.getOfferteInCorso().size()>0)
		lblNewLabel_7.setText(""+a.getOfferteInCorso().get(a.getOfferteInCorso().size()-1).getPrezzo());
		else
			lblNewLabel_7.setText(""+a.getPrezzoIniziale());
		Label lblNewLabel_8 = new Label(shell, SWT.NONE);
		lblNewLabel_8.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_8.setBounds(189, 499, 329, 15);
		lblNewLabel_8.setText("Data "+a.getDurataAsta().getDayOfMonth()+ "/"+(a.getDurataAsta().getMonthValue()+1)+"/" +a.getDurataAsta().getYear()+ "  Orario: "+ a.getDurataAsta().getHour()+":"+a.getDurataAsta().getMinute());

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
	
}

