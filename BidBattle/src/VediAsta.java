import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
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

public class VediAsta {

	protected Shell shell;

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
		
		Group grpProdotto = new Group(shell, SWT.SHADOW_ETCHED_IN);
		grpProdotto.setBackground(SWTResourceManager.getColor(255, 215, 0));
		grpProdotto.setBounds(189, 170, 481, 255);
		grpProdotto.setText("Prodotto");
		
		Label lblNewLabel_2 = new Label(grpProdotto, SWT.NONE);
		lblNewLabel_2.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_2.setBounds(10, 43, 55, 15);
		lblNewLabel_2.setText("TItolo");
		
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
		lblNewLabel_6.setText("Palla da calcio");
		
		Label lblNewLabel_6_1 = new Label(grpProdotto, SWT.NONE);
		lblNewLabel_6_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_6_1.setText("Sport");
		lblNewLabel_6_1.setBounds(10, 165, 118, 15);
		
		Label lblNewLabel_9 = new Label(grpProdotto, SWT.NONE);
		lblNewLabel_9.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_9.setBounds(10, 115, 206, 30);
		lblNewLabel_9.setText("Pallone ufficiale lega serie A 2021-2022 ");
		
		Label lblNewLabel_4 = new Label(shell, SWT.NONE);
		lblNewLabel_4.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_4.setBounds(189, 430, 95, 15);
		lblNewLabel_4.setText("Prezzo attuale");
		
		Label lblTermineAsta = new Label(shell, SWT.NONE);
		lblTermineAsta.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblTermineAsta.setBounds(189, 476, 66, 15);
		lblTermineAsta.setText("Termine asta");
		
		Label lblOraminuti = new Label(shell, SWT.NONE);
		lblOraminuti.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblOraminuti.setBounds(275, 476, 76, 15);
		lblOraminuti.setText("Ora:minuti");
		
		Button btnCreaAsta = new Button(shell, SWT.NONE);
		btnCreaAsta.setBounds(189, 539, 75, 25);
		btnCreaAsta.setText("Offri");
		
		Label lblOffertaScontantaPallone = new Label(shell, SWT.NONE);
		lblOffertaScontantaPallone.setForeground(SWTResourceManager.getColor(0, 0, 0));
		lblOffertaScontantaPallone.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
		lblOffertaScontantaPallone.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblOffertaScontantaPallone.setBounds(302, 86, 228, 39);
		lblOffertaScontantaPallone.setText("Offerta scontanta pallone");
		
		Label lblNewLabel_5 = new Label(shell, SWT.NONE);
		lblNewLabel_5.setToolTipText("");
		lblNewLabel_5.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_5.setBounds(189, 146, 376, 15);
		lblNewLabel_5.setText("Offerta scontata da non perdere , prezzo trattabile al +392222223");
		
		Label lblNewLabel_7 = new Label(shell, SWT.NONE);
		lblNewLabel_7.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_7.setBounds(189, 452, 258, 15);
		lblNewLabel_7.setText("10,00");
		
		Label lblNewLabel_8 = new Label(shell, SWT.NONE);
		lblNewLabel_8.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_8.setBounds(189, 499, 63, 15);
		lblNewLabel_8.setText("15/08/2022");
		
		Label lblNewLabel_8_1 = new Label(shell, SWT.NONE);
		lblNewLabel_8_1.setText("12:00");
		lblNewLabel_8_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_8_1.setBounds(275, 499, 63, 15);

	}
}

