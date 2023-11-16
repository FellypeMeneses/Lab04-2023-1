package list;

import list.EstruturaElementar;

public class ListaLigada implements EstruturaElementar{

    private No cabeca;

    public ListaLigada() {
    cabeca = null;
    }

    @Override
    public boolean buscaElemento(int valor) {
        No n = this.cabeca;
        while(n!=null){
            if(n.getValor()==valor){
                return true;
            }
            n=n.getProximo();
        }
        return false;
    }
    @Override
    public int buscaIndice(int valor) {
        No n = this.cabeca;
        for(int i=0;i<valor;i++){
            n=n.getProximo(); 
        }
        return n.getValor();
    }

    @Override
    public int minimo() {
        if(cabeca==null){
            return Integer.MIN_VALUE;
           }
           No n= cabeca;
           int valorminimo= n.getValor();
           while(n !=null){
            if(n.getValor()<valorminimo){
                valorminimo=n.getValor();
            }
            n=n.getProximo();
           }
           return valorminimo;
        }

 


    @Override
    public int maximo() {
        if(cabeca==null){
            return Integer.MAX_VALUE;
           }
           
           No n= cabeca;
           int valormaximo= n.getValor();
           
           while(n !=null){
            if(n.getValor()>valormaximo){
                valormaximo=n.getValor();
            }
            n=n.getProximo();
           }
           return valormaximo;
        }
       
    @Override
    public int predecessor(int valor) {
        if(cabeca==null||cabeca.getValor()==valor){
            return Integer.MIN_VALUE;
          }
          
          No atual= cabeca;
          
          while(atual.getProximo()!=null){
            if(atual.getProximo().getValor()==valor){
                return atual.getValor();
            }
            atual.getProximo();
          }
          return Integer.MIN_VALUE;
        }
        
    @Override
    public int sucessor(int valor) {
        No atual= cabeca;
        
        while(atual != null && atual.getValor() != valor){
            atual= atual.getProximo();
        }
        
        if(atual!= null && atual.getProximo()!= null){
            return atual.getProximo().getValor();
        }
        return Integer.MIN_VALUE;
    }

    @Override
    public void insereElemento(int valor) {
        No novo= new No(valor);
        
        if(cabeca==null){
            cabeca=novo;
        
        }else{
            novo.setProximo(cabeca);
            cabeca=novo;
        }

    }

    @Override
    public void insereElementoPosicao(int valor, int buscaIndice) {
        No novo = new No(valor);
        
        if (buscaIndice <= 0) {
            novo.setProximo(cabeca);
            cabeca = novo;
        
        } else {
            No atual = cabeca;
            int indice = 0;

            while (atual.getProximo() != null && indice < buscaIndice - 1) {
                atual = atual.getProximo();
                indice++;
            }
            
            No proximo = atual.getProximo();
            atual.setProximo(novo);
            novo.setProximo(proximo);
        }
    }

    @Override
    public void insereInicio(int valor) {
        if (this.cabeca==null){
            this.cabeca = new No(valor);    
            }
            else{
                No n = new No(valor);
                n.setProximo(this.cabeca);
                cabeca = n;
            }
            
        }

    @Override
    public void insereFim(int valor) {
        if(cabeca==null){
            cabeca = new No(valor);
        }
        else{
        No n = cabeca;
        while (n.getProximo()!=null) {
            n=n.getProximo();
        }
        n.setProximo(new No(valor));
    }
    }
    @Override
    public void remove(int valor) {
        if (cabeca == null) {
            return; 
        }
        No atual = cabeca;
        No antes = null;
    
        if (atual.getValor() == valor) {   
            cabeca = atual.getProximo(); 
            return;
        }
        
        while (atual != null && atual.getValor() != valor) {
            antes = atual;
            atual = atual.getProximo();
        }
        
        if (atual != null) {
            antes.setProximo(atual.getProximo());
        }
    }

    @Override
    public void removeIndice(int indice) {
        if(cabeca==null){
            return;
        }
        if(indice ==0){
            cabeca = cabeca.getProximo();
            return;
        }
        No atual = cabeca;
        int ordenacao = 0;

        while(atual!= null && ordenacao<indice-1){
            atual = atual.getProximo();
            ordenacao++;
        }
        if(atual==null || atual.getProximo()==null){
            return;
        }

        No seguinte = atual.getProximo().getProximo();
        atual.setProximo(seguinte);
    }


    @Override
    public void removeInicio() {
        if(cabeca!=null){
            cabeca = cabeca.getProximo();
        }
    }     

    

    @Override
    public void removeFim(){
   
        if(this.cabeca == null || this.cabeca.getProximo()==null){
            this.cabeca=null;
            return;
        }
        No atual = cabeca;
        No antes = null;

        while(atual.getProximo()!=null){
            antes = atual;
            atual = atual.getProximo();
        }
        antes.setProximo(null);
        
    }
    
}