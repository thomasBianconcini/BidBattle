import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;

public class Wallet {

	protected Shell shell;
	private Display display = Display.getDefault();
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Wallet window = new Wallet();
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
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(668, 426);
		shell.setText("SWT Application");
		shell.setBackground(SWTResourceManager.getColor(255, 215, 0));
		Label label = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label.setBackground(SWTResourceManager.getColor(255, 215, 0));
		label.setBounds(135, -19, 2, 696);
		
		Label label_1 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		label_1.setBounds(-11, 135, 148, 2);
		
		Label label_1_1 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		label_1_1.setBounds(-11, 185, 148, 2);
		
		Label label_2 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_2.setBackground(SWTResourceManager.getColor(255, 215, 0));
		label_2.setBounds(-11, 235, 148, 2);
		
		Label label_1_2 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1_2.setBackground(SWTResourceManager.getColor(255, 215, 0));
		label_1_2.setBounds(-11, 285, 148, 10);
		
		Label label_1_3 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1_3.setBackground(SWTResourceManager.getColor(255, 215, 0));
		label_1_3.setBounds(-11, 335, 148, 2);
		
		Label label_1_4 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1_4.setBounds(-11, 385, 148, 2);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel.setBounds(40, 153, 55, 15);
		lblNewLabel.setText("Home");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_1.setText("Profilo\r\n");
		lblNewLabel_1.setBounds(40, 203, 55, 15);
		
		Label lblNewLabel_1_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_1_1.setText("Wallet");
		lblNewLabel_1_1.setBounds(40, 253, 55, 15);
		
		Label lblNewLabel_1_1_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1_1_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_1_1_1.setText("Gestione Asta");
		lblNewLabel_1_1_1.setBounds(32, 303, 78, 15);
		
		Label lblNewLabel_1_1_1_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1_1_1_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_1_1_1_1.setText("Interazione Asta");
		lblNewLabel_1_1_1_1.setBounds(25, 353, 100, 15);
		
		Label lblNewLabel_4 = new Label(shell, SWT.NONE);
		lblNewLabel_4.setBounds(0, 0, 134, 134);
		lblNewLabel_4.setImage(new Image(display,"logo.png"));
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
		lblNewLabel_2.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_2.setBounds(303, 10, 173, 33);
		lblNewLabel_2.setText("Il mio wallet");
		
		Group grpLeMieAste = new Group(shell, SWT.BORDER);
		grpLeMieAste.setText("I miei movimenti");
		grpLeMieAste.setBackground(SWTResourceManager.getColor(255, 215, 0));
		grpLeMieAste.setBounds(178, 61, 375, 405);
		
		Label lblTitoloAsta = new Label(grpLeMieAste, SWT.NONE);
		lblTitoloAsta.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblTitoloAsta.setBounds(10, 55, 223, 15);
		lblTitoloAsta.setText("Movimento: Ricarica , importo: 120,00");
		
		Label lblTitoloAsta_1 = new Label(grpLeMieAste, SWT.NONE);
		lblTitoloAsta_1.setText("Movimento: Prelievo ,importo 180,00");
		lblTitoloAsta_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblTitoloAsta_1.setBounds(10, 95, 223, 15);
		
		Label lblTitoloAsta_1_1 = new Label(grpLeMieAste, SWT.NONE);
		lblTitoloAsta_1_1.setText("Movimento: Prelievo ,importo 180,00");
		lblTitoloAsta_1_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblTitoloAsta_1_1.setBounds(10, 136, 223, 15);
		
		Label lblTitoloAsta_1_1_1 = new Label(grpLeMieAste, SWT.NONE);
		lblTitoloAsta_1_1_1.setText("Movimento: Ricarica , importo: 1000,00");
		lblTitoloAsta_1_1_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblTitoloAsta_1_1_1.setBounds(10, 175, 223, 15);
		
		Label lblTitoloAsta_1_1_1_1 = new Label(grpLeMieAste, SWT.NONE);
		lblTitoloAsta_1_1_1_1.setText("Movimento: Ricarica , importo: 100,00");
		lblTitoloAsta_1_1_1_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblTitoloAsta_1_1_1_1.setBounds(10, 217, 223, 15);
		
		Label lblNewLabel_3 = new Label(grpLeMieAste, SWT.NONE);
		lblNewLabel_3.setBackground(SWTResourceManager.getColor(0, 255, 0));
		lblNewLabel_3.setBounds(333, 55, 10, 10);
		
		Label lblNewLabel_3_1 = new Label(grpLeMieAste, SWT.NONE);
		lblNewLabel_3_1.setBackground(SWTResourceManager.getColor(255, 0, 0));
		lblNewLabel_3_1.setBounds(333, 97, 10, 10);
		
		Label lblNewLabel_3_1_1 = new Label(grpLeMieAste, SWT.NONE);
		lblNewLabel_3_1_1.setBackground(SWTResourceManager.getColor(255, 0, 0));
		lblNewLabel_3_1_1.setBounds(333, 138, 10, 10);
		
		Label lblNewLabel_3_1_2 = new Label(grpLeMieAste, SWT.NONE);
		lblNewLabel_3_1_2.setBackground(SWTResourceManager.getColor(0, 255, 0));
		lblNewLabel_3_1_2.setBounds(333, 177, 10, 10);
		
		Label lblNewLabel_3_1_3 = new Label(grpLeMieAste, SWT.NONE);
		lblNewLabel_3_1_3.setBackground(SWTResourceManager.getColor(0, 255, 0));
		lblNewLabel_3_1_3.setBounds(333, 219, 10, 10);
		
		Label lblTitoloAsta_1_1_1_1_1 = new Label(grpLeMieAste, SWT.NONE);
		lblTitoloAsta_1_1_1_1_1.setText("Movimento: Ricarica , importo: 100,00");
		lblTitoloAsta_1_1_1_1_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblTitoloAsta_1_1_1_1_1.setBounds(10, 300, 223, 15);
		
		Label lblTitoloAsta_1_1_1_2 = new Label(grpLeMieAste, SWT.NONE);
		lblTitoloAsta_1_1_1_2.setText("Movimento: Ricarica , importo: 1000,00");
		lblTitoloAsta_1_1_1_2.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblTitoloAsta_1_1_1_2.setBounds(10, 259, 223, 15);
		
		Label lblNewLabel_3_1_2_1 = new Label(grpLeMieAste, SWT.NONE);
		lblNewLabel_3_1_2_1.setBackground(SWTResourceManager.getColor(0, 255, 0));
		lblNewLabel_3_1_2_1.setBounds(333, 260, 10, 10);
		
		Label lblNewLabel_3_1_3_1 = new Label(grpLeMieAste, SWT.NONE);
		lblNewLabel_3_1_3_1.setBackground(SWTResourceManager.getColor(0, 255, 0));
		lblNewLabel_3_1_3_1.setBounds(333, 301, 10, 10);
		
		Label lblCreaAsta = new Label(shell, SWT.NONE);
		lblCreaAsta.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblCreaAsta.setBounds(574, 50, 55, 15);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setForeground(SWTResourceManager.getColor(0, 255, 0));
		btnNewButton.setBounds(559, 118, 75, 25);
		btnNewButton.setText("Ricarica");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.setForeground(SWTResourceManager.getColor(255, 0, 0));
		btnNewButton_1.setBounds(559, 183, 75, 25);
		btnNewButton_1.setText("Prelievo");

	}
}
