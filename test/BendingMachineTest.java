import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class BendingMachineTest {
	BendingMachene bm;
	
	@Before
	public void init() {
		bm = new BendingMachene();
	}
	
	@Test
	public void お金を投入すると投入金額が加算される() {
		bm.insert(Money.COIN10);
		
		assertThat(10, is(bm.getInsertedMoney()));
	}
	
	@Test
	public void 対象のお金を投入すると0が返る() {
		assertThat(bm.insert(Money.COIN10), is(0));
	}
	
	@Test
	public void 複数回投入できる() {
		bm.insert(Money.COIN10);
		bm.insert(Money.COIN500);
		assertThat(510, is(bm.getInsertedMoney()));
	}
	
	@Test
	public void 払い戻しすると投入金額の総計を釣り銭として出力する() {
		bm.insert(Money.COIN10);
		assertThat(bm.payback(), is(10));
	}
	
	@Test
	public void 払い戻しすると投入金額が0になる() {
		bm.insert(Money.COIN10);
		assertThat(bm.payback(), is(10));
		assertThat(bm.getInsertedMoney(), is(0));
	}
	
	@Test
	public void 対象外のお金を投入するとその金額を返す() {
		int acctual = bm.insert(Money.COIN1);
		int expected = 1;
		
		assertThat(acctual, is(expected));
	}
	
	@Test
	public void 対象外のお金を投入すると投入金額は加算されない() {
		assertThat(bm.insert(Money.COIN5), is(5));
		assertThat(bm.getInsertedMoney(), is(0));
	}
	
	@Test
	public void 初期状態でコーラを5本格納している() {
		assertThat(bm.getRest(Drink.COKE), is(5));
		
		Map<Drink, Integer> expected = new HashMap<Drink, Integer>();
		expected.put(Drink.COKE, 5);
		
		assertThat(bm.getContainedDrinks(), is(expected));
		
	}
	
	@Test
	public void コーラを買えるかどうかを取得_投入金額が充分なら買える() {
		bm.insert(Money.COIN50);
		bm.insert(Money.COIN100);
		
		assertTrue(bm.canPurchaseCoke());
	}
	
	@Test
	public void コーラを買えるかどうかを取得_投入金額が不充分なら買えない() {
		bm.insert(Money.COIN50);
		
		assertFalse(bm.canPurchaseCoke());
	}
	
	@Test
	public void ジュースを買うと在庫が減る() {
		bm.insert(Money.COIN100);
		bm.insert(Money.COIN10);
		bm.insert(Money.COIN10);
		
		bm.purchase();
		assertThat(bm.getRest(Drink.COKE), is(4));
	}
}
