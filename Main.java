
import java.util.ArrayList;
import java.util.List;

// IMPLEMENTAÇÃO DE INTERFACE PIZZA
interface Pizza {
    String getPizza();
}

// IMPLEMENTAÇÃO DE CONCRETA DE SABORES
class MussarelaPizza implements Pizza {
    @Override
    public String getPizza() {
        return "Pizza sabor Mussarela";
    }
}

class CalabresaPizza implements Pizza {
    @Override
    public String getPizza() {
        return "Pizza sabor Calabresa";
    }
}

class CaipiraPizza implements Pizza {
    @Override
    public String getPizza() {
        return "Pizza sabor Caipira";
    }
}

class CheddarPizza implements Pizza {
    @Override
    public String getPizza() {
        return "Borda sabor Cheddar";
    }
}

class CatupiryPizza implements Pizza {
    @Override
    public String getPizza() {
        return "Borda sabor Catupiry";
    }
}

// IMPLEMENTAÇÃO DE INTERFACE DE MASSA
abstract class Massa {
    protected Pizza pizza;

    public Massa(Pizza pizza) {
        this.pizza = pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public abstract void montar();
}

// ABSTRAÇÕES REFINADAS
class RecheioMassa extends Massa {
    public RecheioMassa(Pizza pizza) {
        super(pizza);
    }

    @Override
    public void montar() {
        System.out.println("Recheio de " + this.pizza.getPizza() + ".");
    }
}

class BordaMassa extends Massa {
    public BordaMassa(Pizza pizza) {
        super(pizza);
    }

    @Override
    public void montar() {
        System.out.println("Recheio da " + this.pizza.getPizza() + ".");
    }
}

// CLASSES ATUALIZADAS PARA ITENS DE PEDIDO
class ItemPedido {
    private String nome;
    private double preco;

    public ItemPedido(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public double obterPreco() {
        return preco;
    }
}

class Conteiner {
    private List<ItemPedido> pedidos;

    public Conteiner(String nome) {
        this.pedidos = new ArrayList<>();
    }

    public void adicionar(ItemPedido pedido) {
        pedidos.add(pedido);
    }

    public void remover(ItemPedido pedido) {
        pedidos.remove(pedido);
    }

    public double obterPreco() {
        double precoTotal = 0;
        for (ItemPedido pedido : pedidos) {
            precoTotal += pedido.obterPreco();
        }
        return precoTotal;
    }
}

public class Main {
    public static void main(String[] args) {
        Pizza mussarela = new MussarelaPizza();
        Pizza calabresa = new CalabresaPizza();
        Pizza caipira = new CaipiraPizza();
        Pizza cheddar = new CheddarPizza();
        Pizza catupiry = new CatupiryPizza();

        Massa massa1 = new RecheioMassa(mussarela);
        Massa massa2 = new RecheioMassa(calabresa);
        Massa borda1 = new BordaMassa(cheddar);
        Massa borda2 = new BordaMassa(catupiry);

        massa1.montar();
        massa2.montar();
        borda1.montar();
        borda2.montar();

        ItemPedido mussarelaPedido = new ItemPedido("Pizza Mussarela", 39.50);
        ItemPedido calabresaPedido = new ItemPedido("Pizza Calabresa", 33.00);
        ItemPedido caipiraPedido = new ItemPedido("Pizza Caipira", 38.00);
        ItemPedido CaixaPizzas = new ItemPedido("Embalagem cx Pizza",5.00);

        Conteiner pizzas = new Conteiner("Pizzas");

        pizzas.adicionar(calabresaPedido);
        pizzas.adicionar(mussarelaPedido);
        pizzas.adicionar(caipiraPedido);

      System.out.println("Preço Total: R$" + pizzas.obterPreco());

        Conteiner caixa = new Conteiner("Caixa de Pizza");
      
        caixa.adicionar(new ItemPedido("Embalagem", 5.00));
        caixa.adicionar(new ItemPedido("Embalagem", 5.00));
        caixa.adicionar(new ItemPedido("Embalagem", 5.00));

        System.out.println("Preço Total: R$" + caixa.obterPreco());
    }
}
