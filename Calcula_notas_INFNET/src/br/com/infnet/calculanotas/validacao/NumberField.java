package br.com.infnet.calculanotas.validacao;

import javax.swing.JTextField;  
import javax.swing.text.AttributeSet;  
import javax.swing.text.BadLocationException;  
import javax.swing.text.PlainDocument;  

public class NumberField extends JTextField {  
	// Serial default(n�o sei usar ainda)
	private static final long serialVersionUID = 1L;

	/** 
	 *  Verifica��o para s� aceitar n�meros(copiado)
	 */  

	public NumberField() {  
		this(null);  
	}  

	public NumberField(String text) {  
		super(text);  
		setDocument(new PlainDocument() {
			
			// Serial default(n�o sei usar ainda)
			private static final long serialVersionUID = 1L;

			public void insertString(int offs, String str, AttributeSet a)  
					throws BadLocationException {  
				for (int i = 0; i < str.length(); i++)  
					if (!Character.isDigit(str.charAt(i)))  
						return;  

				super.insertString(offs, str, a);
			}  
		});  
	}  
}