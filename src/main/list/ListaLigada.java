package list;

import list.EstruturaElementar;

public class ListaLigada implements EstruturaElementar{

    public No cabeca;
    private No fim;

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
        int c = Integer.MAX_VALUE;
        No n = this.cabeca;
        while(n!=null){
            if(c>n.getValor()){
                c=n.getValor();
            }
            n=n.getProximo();
        }
        return c;
    }

    @Override
    public int maximo() {
        int c = Integer.MIN_VALUE;
        No n = this.cabeca;
        while(n!=null){
            if(c<n.getValor()){
                c=n.getValor();
            }
            n=n.getProximo();
        }
        return c;
    }

    @Override
    public int predecessor(int valor) {
        return buscaIndice(valor-1);
    }

    @Override
    public int sucessor(int valor) {
       return buscaIndice(valor+1);
    }

    @Override
    public void insereElemento(int valor) {
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
    public void insereElementoPosicao(int valor, int buscaIndice) {
        if(cabeca==null){
            cabeca = new No(valor);
        }
        else if(buscaIndice==0){
            insereInicio(valor);
        }
        else{
            No n = cabeca;
            for(int i = 0;i<buscaIndice-1;i++){
                n=n.getProximo();
            }
            
            No v = n.getProximo();
            n.setProximo(new No(valor));
            n.getProximo().setProximo(v);
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
        if(buscaElemento(valor)){
            No n = cabeca;
            if(n.getValor()==valor){
                cabeca=n.getProximo();
            }
            else{
            while(n!=null){
                if(n.getProximo().getValor()==valor){
                    n.setProximo(n.getProximo().getProximo());
                    break;
                }
                n=n.getProximo();
            }}
        }
        else{}
    }

    @Override
    public void removeIndice(int indice) {
        if(indice==0){
            removeInicio();
        }
        else{No n = this.cabeca;
        for(int i=0;i<indice-1;i++){
            n=n.getProximo(); 
        }
        n.setProximo(n.getProximo().getProximo());}

        
    }

    @Override
    public void removeInicio() {
        if(cabeca==null){}
        else{
            cabeca=cabeca.getProximo();
        }
    }

    @Override
    public void removeFim() {
        if(cabeca==null){}
        else{
        No n = cabeca;
        while (n.getProximo().getProximo()!=null) {
            n=n.getProximo();
        }
        n.setProximo(null);
        }
    }

    public int getIndiceFim(){
        int contador=0;
        No n=cabeca;
        while(n.getProximo()!=null){
            contador++;
            n=n.getProximo();
        }
        return contador+1;
    }

    public int getValorFim(){
       No n=cabeca;
       while (n.getProximo()!=null) {
        n=n.getProximo();
       } 
       return n.getValor();
    }

    public int getValorInicio(){
        return cabeca.getValor();
    }
}