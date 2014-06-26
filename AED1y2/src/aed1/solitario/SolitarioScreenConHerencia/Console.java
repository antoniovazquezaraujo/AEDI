package aed1.solitario.SolitarioScreenConHerencia;
public class Console implements Output {
	String out;
	@Override
	public void paint(Juego juego) {
		out = juego.toString();
	}

	@Override
	public void clear() {
		out = "";
	}

	@Override
	public void paint() {
		System.out.println(out);
	}
}
