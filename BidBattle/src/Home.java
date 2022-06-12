import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import model.DbMock;

import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;

public class Home {

	protected Shell shell;
	private Text txtRicercaPerUtente;
	private Display display = Display.getDefault();
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
		lblNewLabel_4.setImage(new Image(display,"logo.jpg"));
		
		
		
		Group grpLeMieAste = new Group(shell, SWT.BORDER);
		grpLeMieAste.setBackground(SWTResourceManager.getColor(255, 215, 0));
		grpLeMieAste.setBounds(172, 50, 429, 411);
		
		Label lblAsta = new Label(grpLeMieAste, SWT.NONE);
		lblAsta.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblAsta.setBounds(10, 41, 29, 15);
		DbMock db = new DbMock();
		
		lblAsta.setText(db.getUtenti().get(0).getEmail());
		
		Label lblTitoloAsta = new Label(grpLeMieAste, SWT.NONE);
		lblTitoloAsta.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblTitoloAsta.setBounds(10, 66, 223, 15);
		lblTitoloAsta.setText("Titolo: asta1 , Categoria: tecnologia ");
		
		Button btnNewButton = new Button(grpLeMieAste, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewButton.setFont(SWTResourceManager.getFont("Segoe UI", 6, SWT.NORMAL));
		btnNewButton.setBounds(48, 41, 55, 15);
		btnNewButton.setText("Visualizza");
		
		Label lblAsta_1_1 = new Label(grpLeMieAste, SWT.NONE);
		lblAsta_1_1.setText("Asta2");
		lblAsta_1_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblAsta_1_1.setBounds(10, 116, 29, 15);
		
		Label lblTitoloAsta_1_1 = new Label(grpLeMieAste, SWT.NONE);
		lblTitoloAsta_1_1.setText("Titolo: asta2 , Categoria: tecnologia ");
		lblTitoloAsta_1_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblTitoloAsta_1_1.setBounds(10, 141, 223, 15);
		
		Label lblAsta_1_1_1_1 = new Label(grpLeMieAste, SWT.NONE);
		lblAsta_1_1_1_1.setText("Asta3");
		lblAsta_1_1_1_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblAsta_1_1_1_1.setBounds(10, 191, 29, 15);
		
		Label lblTitoloAsta_1_1_1_1 = new Label(grpLeMieAste, SWT.NONE);
		lblTitoloAsta_1_1_1_1.setText("Titolo: asta3 , Categoria: sport ");
		lblTitoloAsta_1_1_1_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblTitoloAsta_1_1_1_1.setBounds(10, 216, 223, 15);
		
		Button btnNewButton_2 = new Button(grpLeMieAste, SWT.NONE);
		btnNewButton_2.setText("Visualizza");
		btnNewButton_2.setFont(SWTResourceManager.getFont("Segoe UI", 6, SWT.NORMAL));
		btnNewButton_2.setBounds(48, 116, 55, 15);
		
		Button btnNewButton_4 = new Button(grpLeMieAste, SWT.NONE);
		btnNewButton_4.setText("Visualizza");
		btnNewButton_4.setFont(SWTResourceManager.getFont("Segoe UI", 6, SWT.NORMAL));
		btnNewButton_4.setBounds(48, 191, 55, 15);
		
		Composite composite = new Composite(grpLeMieAste, SWT.NONE);
		composite.setBounds(316, 17, 64, 64);
		
		Composite composite_1 = new Composite(grpLeMieAste, SWT.NONE);
		composite_1.setBounds(316, 92, 64, 64);
		
		Composite composite_2 = new Composite(grpLeMieAste, SWT.NONE);
		composite_2.setBounds(316, 167, 64, 64);
		
		Composite composite_2_1 = new Composite(grpLeMieAste, SWT.NONE);
		composite_2_1.setBounds(316, 242, 64, 64);
		
		Label lblAsta_1_1_1_1_1 = new Label(grpLeMieAste, SWT.NONE);
		lblAsta_1_1_1_1_1.setText("Asta4");
		lblAsta_1_1_1_1_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblAsta_1_1_1_1_1.setBounds(10, 266, 29, 15);
		
		Label lblTitoloAsta_1_1_1_1_1 = new Label(grpLeMieAste, SWT.NONE);
		lblTitoloAsta_1_1_1_1_1.setText("Titolo: asta4, , Categoria: sport ");
		lblTitoloAsta_1_1_1_1_1.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblTitoloAsta_1_1_1_1_1.setBounds(10, 287, 223, 15);
		
		Button btnNewButton_4_1 = new Button(grpLeMieAste, SWT.NONE);
		btnNewButton_4_1.setText("Visualizza");
		btnNewButton_4_1.setFont(SWTResourceManager.getFont("Segoe UI", 6, SWT.NORMAL));
		btnNewButton_4_1.setBounds(48, 266, 55, 15);
		
		txtRicercaPerUtente = new Text(shell, SWT.BORDER);
		txtRicercaPerUtente.setText("ricerca per utente o asta");
		txtRicercaPerUtente.setBounds(172, 23, 331, 23);
		
		Combo combo = new Combo(shell, SWT.NONE);
		combo.setBounds(502, 23, 99, 23);
		combo.setText("Filtra");
	
	}
}