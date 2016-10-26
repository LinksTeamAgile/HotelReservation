package hotelReservation;

public class CustomerConcrete extends Customer {

	public CustomerConcrete(String taxCode, String name, String surname, String cellPhoneNumber, String mailAddress,
			String cardNumber) {
		super(taxCode, name, surname, cellPhoneNumber, mailAddress, cardNumber);

	}

	@Override
	public void print() {
		System.out.println(super.toString());
	}

}
