
public class IdentifierMain {
	public static void main(String[] args) {

		if (args.length == 0) {
			System.out.print("Uso: IdentifierMain");
		} else {
			Identifier id = new Identifier();
			if (id.validateIdentifier(args[0])) {
				System.out.print("Valido");
			} else {
				System.out.print("Invalido");
			}
		}
	}
}
