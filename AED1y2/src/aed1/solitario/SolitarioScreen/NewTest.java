package aed1.solitario.SolitarioScreen;
import org.junit.Test;



public class NewTest {
	@Test
	public void f() {
		Carta a = new Carta(1, Palo.BASTOS);
		Carta b = new Carta(2, Palo.BASTOS);
		assert (!a.isApilable(a));
		assert (a.isApilable(b));
		assert (!b.isApilable(a));
	}

	@Test
	public void f1() {
		Monton m = new Monton();
		Carta c = new Carta(1, Palo.BASTOS);
		m.addCard(c);
		assert (m.getLastCard() == c);
		Carta d = new Carta(4, Palo.OROS);
		m.addCard(d);
		assert (m.getLastCard() == d);
		assert (m.getAnteLastCard() == c);
		Carta x = m.extractCard();
		assert (x == d);
		x = m.extractCard();
		assert (x == c);
		assert (m.isEmpty());
	}

	@Test
	public void f3() {
		Monton m = new Monton();
		for (int n = 0; n < Carta.MAX_CARD; n++) {
			Carta c = new Carta(n, Palo.OROS);
			m.addCardUp(c);
		}
		assert (m.numCartas == Carta.MAX_CARD );
		for (int n = 0; n < Carta.MAX_CARD; n++) {
			Carta c = m.getLastCard();
			Carta x = m.removeLastCard();
			assert (x == c);
		}
		assert (m.isEmpty());
	}
	public void f4() {
		Monton m = new Monton();
		for (int n = Carta.MAX_CARD-1; n >=0 ; n--) {
			Carta c = new Carta(n, Palo.OROS);
			m.addCardDown(c);
		}
		assert (m.numCartas == Carta.MAX_CARD );
		for (int n = 0; n < Carta.MAX_CARD; n++) {
			Carta c = m.getLastCard();
			Carta x = m.removeLastCard();
			assert (x == c);
		}
		assert (m.isEmpty());
	}
}
