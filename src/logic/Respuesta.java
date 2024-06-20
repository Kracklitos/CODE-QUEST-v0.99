package logic;

public class Respuesta {
	  private String texto;
	  private boolean esCorrecta;

	    public Respuesta(String texto, boolean esCorrecta) {
	        setTexto(texto);
	        setEsCorrecta(esCorrecta);
	    }

		public String getTexto() {
			return texto;
		}

		public void setTexto(String texto) {
			if(texto != null && !texto.trim().isEmpty() )
			this.texto = texto;
			else
				throw new IllegalArgumentException("El texto no puede estar vacío ni contener solo espacios.");
		}

		public boolean isEsCorrecta() {
			return esCorrecta;
		}

		public void setEsCorrecta(boolean esCorrecta) {
			this.esCorrecta = esCorrecta;
		}
	    
	    
}
