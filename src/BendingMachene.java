import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BendingMachene {
	private Set<Money> acceptedMoney = new HashSet<Money>();
	{
		acceptedMoney.add(Money.COIN10);
		acceptedMoney.add(Money.COIN50);
		acceptedMoney.add(Money.COIN100);
		acceptedMoney.add(Money.COIN500);
		acceptedMoney.add(Money.BILL1000);
	}
	
	Map<Drink, Integer> containtedDrinks = new HashMap<Drink, Integer>();
	{
		containtedDrinks.put(Drink.COKE, 5);
	}
	
	private int insertedMoney = 0;
	
	public int insert(Money money) {
		if (acceptedMoney.contains(money)) {
			insertedMoney += money.getValue();
			return 0;
		} else {
			return money.getValue();
		}
	}

	public int getInsertedMoney() {
		return insertedMoney;
	}

	public int payback() {
		int back = insertedMoney;
		insertedMoney = 0;
		return back;
	}

	public Map<Drink, Integer> getContainedDrinks() {
		Map<Drink, Integer> ret = new HashMap<Drink, Integer>();
		ret.putAll(containtedDrinks);
		return ret;
	}

	public int getRest(Drink drink) {
		return containtedDrinks.get(drink);
	}

	public boolean canPurchaseCoke() {
		return insertedMoney >= Drink.COKE.getPrice();
	}

	public Drink purchase() {
		Integer rem = containtedDrinks.get(Drink.COKE);
		containtedDrinks.put(Drink.COKE, rem -1);
		return Drink.COKE;
	}

}
