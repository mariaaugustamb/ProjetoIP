import java.util.Scanner;

public class main {

	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		String insertedName = null;
		String insertedType;

		boolean b = false;

		System.out.println("Digite um nome para esta magia, com a primeira letra maíuscula e o restante contendo apenas letras minúsculas, números ou espaços:");
		while(insertedName == null || !insertedName.matches("[A-Z][a-z[ \t][0-9]]*")){
			if(b) {
				System.out.println("Digite um nome válido como instruído acima!");
			}
			insertedName = in.nextLine();
			b = true;
		}

		b = false;
		System.out.println("Digite qual tipo você deseja que sua magia seja: Fire, Ice, Lightning, Shadow.(Digite exatamente como está escrito):");
		insertedType = in.nextLine();

		while (!b) {
			if (insertedType.equals("Fire") || insertedType.equals("Ice") || insertedType.equals("Lightning") || insertedType.equals("Shadow")){
				b = true;
			}else{
				System.out.println("Verifique novamente os tipos disponíveis.");
				insertedType = in.nextLine();
			}
		}
	}
}
