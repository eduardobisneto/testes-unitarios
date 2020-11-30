import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(EstoqueProduto.class)

public class TestEstoqueProduto {

    @Test
    public void consultaEstoqueTeste(){

        int estoqueEsperado = 10;
        int estoqueAtual = 0;

        EstoqueProduto estoque = new EstoqueProduto(1);
        estoqueAtual = estoque.getSaldoEstoque();

        Assert.assertEquals(estoqueEsperado,estoqueAtual);

    }

    @Test
    public void somaEstoqueTeste(){
        int estoqueEsperado = 10;
        int estoqueAtual = 0;

        EstoqueProduto estoque = new EstoqueProduto(2);
        estoqueAtual = estoque.setSaldoEstoque(7);

        Assert.assertEquals(estoqueEsperado,estoqueAtual);
    }

    @Test
    public void estoqueBaixoTeste(){

        boolean esperado = true;
        boolean reporEstoque = false;

        EstoqueProduto estoque = new EstoqueProduto(2);
        reporEstoque = estoque.consultaReposicao();

        Assert.assertEquals(esperado,reporEstoque);

    }


    @Test
    public void estoqueAltoTeste(){

        boolean esperado = false;
        boolean reporEstoque = false;

        EstoqueProduto estoque = new EstoqueProduto(1);
        reporEstoque = estoque.consultaReposicao();

        Assert.assertEquals(esperado,reporEstoque);

    }

    @Test
    public void estoqueLimiteTeste(){

        boolean esperado = false;
        boolean reporEstoque = false;

        EstoqueProduto estoque = new EstoqueProduto(3);
        reporEstoque = estoque.consultaReposicao();

        Assert.assertEquals(esperado,reporEstoque);

    }

    @Test
    public void removerSaldoEstoqueNegativoTeste(){

        int esperado = 5;
        int saldo = 0;

        EstoqueProduto estoque = new EstoqueProduto(3);
        saldo = estoque.removeSaldo(-10);

        Assert.assertEquals(esperado,saldo);

    }

    @Test
    public void removerEstoqueZeroTeste(){

        int esperado = 5;
        int saldo = 0;

        EstoqueProduto estoque = new EstoqueProduto(3);
        saldo = estoque.removeSaldo(0);

        Assert.assertEquals(esperado,saldo);

    }

    @Test
    public void removerMaisQueSaldoAtual(){

        int esperado = 5;
        int saldo = 0;

        EstoqueProduto estoque = new EstoqueProduto(3);
        saldo = estoque.removeSaldo(10);
        Assert.assertEquals(esperado,saldo);

    }

    @Test
    public void removerEstoqueMenosQueSaldoAtual(){

        int esperado = 1;
        int saldo = 0;

        EstoqueProduto estoque = new EstoqueProduto(3);
        saldo = estoque.removeSaldo(4);
        Assert.assertEquals(esperado,saldo);

    }

    @Test
    public void adicionaProdutoTeste(){

        boolean produtoAdicionado = false;
        int saldoNovoProduto = 10;
        int saldoEsperado = 10;
        int saldoConsultado = 0;
        int codProd = 4;

        EstoqueProduto estoque = new EstoqueProduto();
        produtoAdicionado = estoque.adicionaProduto(codProd,saldoNovoProduto);

        if(produtoAdicionado){
            saldoConsultado = estoque.getSaldoEstoque();
            Assert.assertEquals(saldoEsperado,saldoConsultado);
        }else{
            System.out.println("Produto nao adicionado");
        }

    }

    @Test
    public void adicionaProdutoExistente(){

        boolean produtoAdicionado = false;
        int saldoNovoProduto = 10;
        int saldoEsperado = 10;
        int saldoConsultado = 0;
        int codProd = 1;

        EstoqueProduto estoque = new EstoqueProduto();
        produtoAdicionado = estoque.adicionaProduto(codProd,saldoNovoProduto);

        if(produtoAdicionado){
            saldoConsultado = estoque.getSaldoEstoque();
            Assert.assertEquals(saldoEsperado,saldoConsultado);
        }else{
            System.out.println("Produto nao adicionado!");
        }

    }

    @Test
    public void mockTesteAdicaoEstoque()  throws Exception{

        int valorEsperado = 30;
        int novoValor = 0;
        final String METHOD="getSaldoEstoque";

        EstoqueProduto estoqueMock = new EstoqueProduto(1);
        EstoqueProduto spy = PowerMockito.spy(estoqueMock);
        PowerMockito.when(spy, METHOD).thenReturn(20);
        novoValor = spy.setSaldoEstoque(10);

        Assert.assertEquals(valorEsperado, novoValor, 0);
    }

}
