import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.dnd.DND;

public class Profilo {

	protected Shell shell;
	private Display display = Display.getDefault();
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
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(255, 215, 0));
		shell.setSize(668, 426);
		shell.setText("SWT Application");
		
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
		

		Label lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setBounds(172, 68, 84, 84);
		lblNewLabel_3.setImage(new Image(display,"ProfilePic.jpg"));
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
		lblNewLabel_2.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel_2.setBounds(311, 10, 139, 33);
		lblNewLabel_2.setText("NomeUtente");
		
		Group grpLeMieAste = new Group(shell, SWT.BORDER);
		grpLeMieAste.setText("Aste:");
		grpLeMieAste.setBackground(SWTResourceManager.getColor(255, 215, 0));
		grpLeMieAste.setBounds(172, 180, 432, 267);
		
		Label lblAsta = new Label(grpLeMieAste, SWT.NONE);
		lblAsta.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblAsta.setBounds(10, 35, 55, 15);
		lblAsta.setText("Asta1");
		
		Label lblTitoloAsta = new Label(grpLeMieAste, SWT.NONE);
		lblTitoloAsta.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblTitoloAsta.setBounds(10, 55, 223, 15);
		lblTitoloAsta.setText("Titolo: asta1 , Categoria: tecnologia ");
		
		Button btnNewButton = new Button(grpLeMieAste, SWT.NONE);
		btnNewButton.setFont(SWTResourceManager.getFont("Segoe UI", 6, SWT.NORMAL));
		btnNewButton.setBounds(345, 56, 55, 15);
		btnNewButton.setText("Visualizza");
		
		Label lblAsta_1 = new Label(grpLeMieAste, SWT.NONE);
		lblAsta_1.setText("Asta2");
		lblAsta_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblAsta_1.setBounds(10, 75, 55, 15);
		
		Label lblTitoloAsta_1 = new Label(grpLeMieAste, SWT.NONE);
		lblTitoloAsta_1.setText("Titolo: asta2 , Categoria: sport ");
		lblTitoloAsta_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblTitoloAsta_1.setBounds(10, 95, 223, 15);
		
		Label lblAsta_1_1 = new Label(grpLeMieAste, SWT.NONE);
		lblAsta_1_1.setText("Asta3");
		lblAsta_1_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblAsta_1_1.setBounds(10, 115, 55, 15);
		
		Label lblTitoloAsta_1_1 = new Label(grpLeMieAste, SWT.NONE);
		lblTitoloAsta_1_1.setText("Titolo: asta3 , Categoria: tecnologia ");
		lblTitoloAsta_1_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblTitoloAsta_1_1.setBounds(10, 136, 223, 15);
		
		Label lblAsta_1_1_1 = new Label(grpLeMieAste, SWT.NONE);
		lblAsta_1_1_1.setText("Asta4");
		lblAsta_1_1_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblAsta_1_1_1.setBounds(10, 154, 55, 15);
		
		Label lblTitoloAsta_1_1_1 = new Label(grpLeMieAste, SWT.NONE);
		lblTitoloAsta_1_1_1.setText("Titolo: asta4 , Categoria abbigliamento\r\n");
		lblTitoloAsta_1_1_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblTitoloAsta_1_1_1.setBounds(10, 175, 223, 15);
		
		Label lblAsta_1_1_1_1 = new Label(grpLeMieAste, SWT.NONE);
		lblAsta_1_1_1_1.setText("Asta5");
		lblAsta_1_1_1_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblAsta_1_1_1_1.setBounds(10, 196, 55, 15);
		
		Label lblTitoloAsta_1_1_1_1 = new Label(grpLeMieAste, SWT.NONE);
		lblTitoloAsta_1_1_1_1.setText("Titolo: asta5 , Categoria: sport ");
		lblTitoloAsta_1_1_1_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblTitoloAsta_1_1_1_1.setBounds(10, 217, 223, 15);
		
		Button btnNewButton_1 = new Button(grpLeMieAste, SWT.NONE);
		btnNewButton_1.setText("Visualizza");
		btnNewButton_1.setFont(SWTResourceManager.getFont("Segoe UI", 6, SWT.NORMAL));
		btnNewButton_1.setBounds(345, 96, 55, 15);
		
		Button btnNewButton_2 = new Button(grpLeMieAste, SWT.NONE);
		btnNewButton_2.setText("Visualizza");
		btnNewButton_2.setFont(SWTResourceManager.getFont("Segoe UI", 6, SWT.NORMAL));
		btnNewButton_2.setBounds(345, 136, 55, 15);
		
		Button btnNewButton_3 = new Button(grpLeMieAste, SWT.NONE);
		btnNewButton_3.setText("Visualizza");
		btnNewButton_3.setFont(SWTResourceManager.getFont("Segoe UI", 6, SWT.NORMAL));
		btnNewButton_3.setBounds(345, 175, 55, 15);
		
		Button btnNewButton_4 = new Button(grpLeMieAste, SWT.NONE);
		btnNewButton_4.setText("Visualizza");
		btnNewButton_4.setFont(SWTResourceManager.getFont("Segoe UI", 6, SWT.NORMAL));
		btnNewButton_4.setBounds(310, 217, 55, 15);
		
		Button btnNuova = new Button(shell, SWT.NONE);
		btnNuova.setText("Modifica dati");
		btnNuova.setFont(SWTResourceManager.getFont("Segoe UI", 6, SWT.NORMAL));
		btnNuova.setBounds(549, 22, 55, 15);
		
		Label lblDescrizione = new Label(shell, SWT.BORDER);
		lblDescrizione.setBounds(303, 68, 301, 84);
		lblDescrizione.setText("Descrizione");
		


	}
}

