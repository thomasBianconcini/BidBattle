import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;

public class AnalisiDati {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			AnalisiDati window = new AnalisiDati();
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
		shell.setAlpha(250);
		shell.setSize(758, 444);
		shell.setText("SWT Application");
		shell.setLayout(null);
		
		Label lblAnalisDati = new Label(shell, SWT.NONE);
		lblAnalisDati.setBounds(304, 25, 96, 28);
		lblAnalisDati.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
		lblAnalisDati.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblAnalisDati.setText("Analisi dati");
		
		Label lblCategoria = new Label(shell, SWT.NONE);
		lblCategoria.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblCategoria.setBounds(108, 90, 55, 15);
		lblCategoria.setText("Categoria:");
		
		Combo combo = new Combo(shell, SWT.NONE);
		combo.setBounds(108, 120, 72, 23);
		
		Label lblPeriodo = new Label(shell, SWT.NONE);
		lblPeriodo.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblPeriodo.setText("Periodo:");
		lblPeriodo.setBounds(108, 150, 55, 15);
		
		Label lblDa = new Label(shell, SWT.NONE);
		lblDa.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblDa.setText("Da:");
		lblDa.setBounds(108, 180, 55, 15);
		
		Label lblA = new Label(shell, SWT.NONE);
		lblA.setBackground(SWTResourceManager.getColor(255, 215, 0));
		lblA.setText("A:");
		lblA.setBounds(108, 230, 55, 15);
		
		DateTime dateTime = new DateTime(shell, SWT.BORDER);
		dateTime.setBounds(108, 200, 80, 24);
		
		DateTime dateTime_1 = new DateTime(shell, SWT.BORDER);
		dateTime_1.setBounds(108, 250, 80, 24);
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBounds(250, 90, 432, 268);
		
		Button btnGeneraGrafico = new Button(shell, SWT.NONE);
		btnGeneraGrafico.setBounds(105, 333, 89, 25);
		btnGeneraGrafico.setText("Genera grafico");

	}
}
