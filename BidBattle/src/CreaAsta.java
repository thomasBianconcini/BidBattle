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

public class CreaAsta {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			CreaAsta window = new CreaAsta();
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
		
		Label lblCreaasta = new Label(shell, SWT.NONE);
		lblCreaasta.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblCreaasta.setForeground(SWTResourceManager.getColor(0, 0, 0));
		lblCreaasta.setBounds(189, 45, 77, 28);
		lblCreaasta.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
		lblCreaasta.setText("CreaAsta");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel.setBounds(189, 78, 33, 15);
		lblNewLabel.setText("Titolo:");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(189, 98, 162, 21);
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_1.setBounds(189, 124, 63, 15);
		lblNewLabel_1.setText("Descrizione:");
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(189, 144, 481, 21);
		
		Group grpProdotto = new Group(shell, SWT.SHADOW_ETCHED_IN);
		grpProdotto.setBackground(SWTResourceManager.getColor(255, 215, 0));
		grpProdotto.setBounds(189, 170, 481, 255);
		grpProdotto.setText("Prodotto");
		
		Label lblNewLabel_2 = new Label(grpProdotto, SWT.NONE);
		lblNewLabel_2.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_2.setBounds(10, 43, 55, 15);
		lblNewLabel_2.setText("TItolo");
		
		text_2 = new Text(grpProdotto, SWT.BORDER);
		text_2.setBounds(10, 64, 76, 21);
		
		Label lblNewLabel_3 = new Label(grpProdotto, SWT.NONE);
		lblNewLabel_3.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_3.setBounds(10, 91, 94, 15);
		lblNewLabel_3.setText("Descrizione");
		
		text_3 = new Text(grpProdotto, SWT.BORDER);
		text_3.setBounds(10, 112, 118, 21);
		
		Label lblCategoria = new Label(grpProdotto, SWT.NONE);
		lblCategoria.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblCategoria.setBounds(10, 144, 55, 15);
		lblCategoria.setText("Categoria");
		
		Combo combo = new Combo(grpProdotto, SWT.NONE);
		combo.setBounds(10, 165, 91, 23);
		
		Label lblImmagine = new Label(grpProdotto, SWT.NONE);
		lblImmagine.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblImmagine.setBounds(230, 43, 55, 15);
		lblImmagine.setText("Immagine");
		
		Group group = new Group(grpProdotto, SWT.NONE);
		group.setBackground(SWTResourceManager.getColor(240, 255, 255));
		group.setBounds(230, 64, 241, 181);
		
		DropTarget dropTarget = new DropTarget(group, DND.DROP_MOVE);
		
		Label lblNewLabel_4 = new Label(shell, SWT.NONE);
		lblNewLabel_4.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_4.setBounds(189, 430, 95, 15);
		lblNewLabel_4.setText("Prezzo di partenza");
		
		text_4 = new Text(shell, SWT.BORDER);
		text_4.setBounds(189, 450, 481, 21);
		
		Label lblTermineAsta = new Label(shell, SWT.NONE);
		lblTermineAsta.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblTermineAsta.setBounds(189, 476, 66, 15);
		lblTermineAsta.setText("Termine asta");
		
		DateTime dateTime = new DateTime(shell, SWT.BORDER);
		dateTime.setBounds(189, 496, 80, 24);
		
		Label lblOraminuti = new Label(shell, SWT.NONE);
		lblOraminuti.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblOraminuti.setBounds(275, 476, 76, 15);
		lblOraminuti.setText("Ora:minuti");
		
		text_5 = new Text(shell, SWT.BORDER);
		text_5.setBounds(275, 496, 76, 21);
		
		Button btnCreaAsta = new Button(shell, SWT.NONE);
		btnCreaAsta.setBounds(189, 539, 75, 25);
		btnCreaAsta.setText("Crea asta");

	}
}
