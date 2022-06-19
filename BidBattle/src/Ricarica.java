import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import controller.GestioneWalletController;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class Ricarica {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
private Shell shellWallet;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Ricarica window = new Ricarica();
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
		shell.setSize(312, 472);
		shell.setText("SWT Application");
		shell.setLayout(null);
		
		Label lblOfferta = new Label(shell, SWT.NONE);
		lblOfferta.setBounds(34, 28, 96, 28);
		lblOfferta.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
		lblOfferta.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblOfferta.setText("Ricarica");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(34, 84, 117, 15);
		lblNewLabel.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblNewLabel.setText("Nome Intestatario:");
		
		Label lblImporto = new Label(shell, SWT.NONE);
		lblImporto.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblImporto.setBounds(34, 144, 43, 15);
		lblImporto.setText("N. carta:");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(34, 174, 148, 21);
		
		
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(34, 117, 148, 21);
		
		Label lblMmaa = new Label(shell, SWT.NONE);
		lblMmaa.setText("MM//AA");
		lblMmaa.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblMmaa.setBounds(34, 204, 68, 15);
		
		Label lblCvv = new Label(shell, SWT.NONE);
		lblCvv.setText("CVV");
		lblCvv.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblCvv.setBounds(108, 204, 43, 15);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(34, 234, 49, 21);
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(102, 234, 49, 21);
		
		Label lblImport = new Label(shell, SWT.NONE);
		lblImport.setText("Importo:");
		lblImport.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblImport.setBounds(34, 264, 68, 15);
		
		text_4 = new Text(shell, SWT.BORDER);
		text_4.setBounds(34, 294, 49, 21);
		Button btnOffri = new Button(shell, SWT.NONE);
		btnOffri.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if(!text_1.getText().isEmpty() && !text_2.getText().isEmpty() && !text_3.getText().isEmpty()&& !text.getText().isEmpty())
				{
					GestioneWalletController gc = new  GestioneWalletController();
					gc.ricarica(Double.parseDouble(text_4.getText()), "euro");
					Wallet w = new Wallet();
					shell.close();
					w.open();
				}
				
			}
		});

		btnOffri.setBounds(133, 292, 49, 25);
		btnOffri.setText("Ricarica");
	}

	public Shell getShellWallet() {
		return shellWallet;
	}

	public void setShellWallet(Shell shellWallet) {
		this.shellWallet = shellWallet;
	}

}

