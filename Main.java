import java.util.Scanner;
import java.util.Optional;

public class Main
{
	class Carro {
		private String chassi;
		private String nomeCarro;
		private int capacidadeTanqueLitros = 50;
		private int litrosAtuais = 35;

		Carro(String nome, String chassi, int capacidadeTanqueLitros) {
			this.chassi = chassi;
			this.nomeCarro = nome;
			this.capacidadeTanqueLitros = capacidadeTanqueLitros;
		}
		public String getInformacoesCarro() {
			return this.nomeCarro
			       .concat(" com um ")
			       .concat(this.chassi);
		}

		public double getVlEncherTanque(double precoGasolina) {
			return (double) precoGasolina * (capacidadeTanqueLitros - litrosAtuais);
		}
	}
	
	class ContaBancaria {
	    private double saldo;
	    private String titular;
	    ContaBancaria(String titular) {
	        this.titular = titular;
	        this.saldo = 0;
	    }
	    public boolean depositar(double valor) {
	        if (valor <= 0)
	            return false;
	       this.saldo += valor;
	       return true;
	    }
	    public Optional<Double> sacar(double valor) {
	        if (valor <= 0 || valor < this.saldo)
	            return Optional.empty();
	        this.saldo -= valor;
	        return Optional.of(this.saldo);
	    }
	}
    class Produto {
        private String nome;
        private int quantidadeEstoque;
        private double preco;
        
        Produto(String nome, int quantidadeEstoque, double preco) {
            this.setNome(nome);
            this.setQuantidadeEstoque(quantidadeEstoque);
            this.setPreco(preco);
        }
        public String getNome() {
            return nome;
        }
    
        public void setNome(String nome) {
            this.nome = nome;
        }
    
    
        public int getQuantidadeEstoque() {
            return quantidadeEstoque;
        }
    
    
        public boolean setQuantidadeEstoque(int quantidadeEstoque) {
            if (quantidadeEstoque < 0)
                return false;
            this.quantidadeEstoque = quantidadeEstoque;
            return true;
        }
    
        public double getPreco() {
            return preco;
        }
    
        public boolean setPreco(double preco) {
            if (preco < 0)
                return false;
            this.preco = preco;
            return true;
        }
    }

	class Menu {
	    private String getStringScanner(String msg) {
	        System.out.println(msg);
            return scan.nextLine();
	    }
	    private int getIntScanner(String msg) {
	        System.out.println(msg);
	        return scan.nextInt();
	    }
	    private double getDoubleScanner(String msg) {
	        System.out.println(msg);
	        return scan.nextDouble();
	    }
	    public Main.ContaBancaria cadastrarContaBancaria() {
	        return new Main().
	            new ContaBancaria(this.getStringScanner("me diga o nome do titular da conta"));
	    }
		public Main.Carro cadastrarCarro() {
		    return new Main().new Carro (
		        this.getStringScanner("insira o nome do carro."),
		        this.getStringScanner("insira o chassi do carro."),
		        this.getIntScanner("insira a capacidade do tanque em litros do carro")
	        );
		}
		public Main.Produto cadastrarProduto() {
		    return new Main().new Produto(
	            this.getStringScanner("insira o nome do produto"),
	            this.getIntScanner("insira a quantidade do produto"),
	            this.getDoubleScanner("insira o preco do produto")
	        );
		}
	}
	static Scanner scan = new Scanner(System.in);
	static Main.Menu menu = (new Main()).new Menu();
	private static void testarContaBancaria() {
	    Main.ContaBancaria conta = menu.cadastrarContaBancaria();
		conta.depositar(20.50);
		if(!conta.depositar(-150.5))
		    System.out.println("impossível depositar valores negativos");
	    if(conta.sacar(15.0).isPresent())
	        System.out.println("conseguimos sacar um valor menor do que seu saldo");
        if(conta.sacar(4101).isEmpty())
            System.out.println("impossível sacar um valor maior do disponível");
	}
	private static void testarProduto() {
	    Main.Produto produto = menu.cadastrarProduto();
	    if(!produto.setQuantidadeEstoque(-50))
	        System.out.println("impossível a quantidade de um produto ser menor que zero");
        if(!produto.setPreco(-52.0))
	        System.out.println("impossível o preço de um produto ser menor que zero");
	}
	public static void main(String[] args) {
		Main.testarContaBancaria();
		Main.testarProduto();
	}

}
