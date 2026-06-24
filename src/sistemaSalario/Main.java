package sistemaSalario;

import java.util.Scanner;

import model.Funcionario;

public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);

		System.out.println("Nome ");
		var nome = sc.nextLine();

		System.out.println("Salario ");
		var salario = sc.nextDouble();

		sc.nextLine();

		var menu = """
				=== Cargos ===
				1 - Gerente
				2 - Vendedor
				3 - Estagiário
				===========
				Escolha:
				""";
		System.out.println(menu);
		var opcao = sc.nextLine();

		var cargo = switch (opcao) {
			case "1" -> "Gerente";
			case "2" -> "Vendedor";
			case "3" -> "Estagiário";

			default -> "Cargo Inválido";
		};

		var funcionario = new Funcionario(nome, salario, cargo);
		double bonus = calcularBonus(cargo, salario);
		double salarioFinal = calcularSalarioFinal(salario, bonus);
		exibirRelatorio(funcionario, bonus, salarioFinal);
		sc.close();
	}

	public static double calcularBonus(String cargo, double salario) {
		return switch (cargo) {
		case "Gerente" -> 1500;
		case "Vendedor" -> salario * 0.10;
		case "Estagiário" -> 300;
		default -> 0;
		};
	}

	public static double calcularSalarioFinal(double salario, double bonus) {
		return salario + bonus;
	}

	public static void exibirRelatorio(Funcionario funcionario, double bonus, double salarioFinal) {
		System.out.println("""
				===========================
				relatórios Funcionários
				===========================
				""");
		System.out.println("Nome: " + funcionario.nome());
		System.out.println("Cargo: " + funcionario.cargo());
		System.out.printf("Salario R$: %.2f%n ", funcionario.salario());
		System.out.printf("Bonus R$: %.2f%n ", bonus);
		System.out.printf("Salário final R$: %.2f%n", salarioFinal);
	}

}
