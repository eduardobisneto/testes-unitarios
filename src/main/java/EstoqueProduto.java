import java.util.HashMap;

public class EstoqueProduto {

    // key = codigo ; value = saldo;
    private HashMap<Integer,Integer> produtos = new HashMap<Integer, Integer>();

    private int codProd = 0;
    private int estoqueMinino = 5;
    public int saldoEmEstoque = 0;


    public EstoqueProduto(int codProduto){

        setProdutos();
        this.codProd = codProduto;
        this.saldoEmEstoque = this.produtos.get(codProduto);

    }

    public EstoqueProduto(){

        setProdutos();
        this.codProd = 0;
        this.saldoEmEstoque = 0;

    }

    private void setProdutos(){
        this.produtos.put(1,10);
        this.produtos.put(2,3);
        this.produtos.put(3,5);
    }

    public boolean consultaReposicao(){

        boolean reporEstoque = false;

        if(this.produtos.get(this.codProd) < this.estoqueMinino){
            System.out.print("Repor o estoque do produto "+this.codProd);
            reporEstoque = true;

        }else{
            System.out.print("Estoque sufuciente");
            reporEstoque = false;
        }

        return reporEstoque;
    }

    //retorna a quantidade em estoque de determinado produto
    public int getSaldoEstoque(){
        this.saldoEmEstoque = this.produtos.get(this.codProd);
        return this.saldoEmEstoque;
    }

    public int setSaldoEstoque(int quantidade){

        int saldoAtual = getSaldoEstoque();
        int novaSaldo = saldoAtual + quantidade;

        this.produtos.put(this.codProd, novaSaldo);

        System.out.println("Novo Saldo:"+saldoAtual);

        return  novaSaldo;
    }

    public int removeSaldo(int quantidade){

        int saldoAtual = getSaldoEstoque();

        if (quantidade > 0){
            if(!(quantidade > saldoAtual)){
                this.produtos.put(this.codProd, saldoAtual - quantidade);
            }else{
                System.out.println("Quantidade a ser removida maior que o saldo atual!\n O estoque nao sera alterado");
            }
        }else{
            System.out.println("Quantidade a ser removida deve ser maior que o 0!\n O estoque nao sera alterado");
        }

        saldoAtual = getSaldoEstoque();

        return saldoAtual;
    }

    public boolean adicionaProduto(int codProd,int saldo){

        boolean produtoAdicionado = false;

        if(!this.produtos.containsKey(codProd)){
            this.produtos.put(codProd,saldo);
            this.codProd = codProd;
            System.out.println("Produto adicionado com sucesso!");
            produtoAdicionado = true;
        }else{
            System.out.println("O produto informado ja existe no cadastro");
            produtoAdicionado = false;
        }

        return produtoAdicionado;
    }

}
