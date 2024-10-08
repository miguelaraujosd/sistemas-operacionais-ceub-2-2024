package projeto_threads_so;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

import javax.swing.JLabel;
import javax.swing.JTextField;


	public class Acao_Botao implements ActionListener {
		
		private JTextField primeiro;
		private JTextField segundo;
		private JLabel resultado;
		
		public Acao_Botao(
				JTextField primeiro, 
				JTextField segundo,
				JLabel resultado) {
			super();
			this.primeiro = primeiro;
			this.segundo = segundo;
			this.resultado = resultado;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			Thread thread = new Thread(new Runnable() {
			
				@Override
				public void run() {
					
					long valor1 = Long.parseLong(primeiro.getText());
					long valor2 = Long.parseLong(segundo.getText());
					BigInteger calculo = new BigInteger("0");
					
					for(int i = 0; i < valor1; i++) {
						for(int j = 0; j < valor2; j++) {
							calculo = calculo.add(new BigInteger("1"));
						}
					}
					
					System.out.println("Terminou a Opera��o");
					
					resultado.setText(calculo.toString());
				}

		});
		
		thread.start();
		
	}
}
		

