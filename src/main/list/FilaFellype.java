package list;
public class FilaFellype{
    ListaLigada lista=null;

    public void	enqueue(int item){
        lista.insereFim(item);
    }

    public int	dequeue(){
        int a = lista.getValorInicio();
        lista.removeInicio();
        return a;
    }

    public boolean isEmpty(){
        if(lista.cabeca==null){
            return true;
        }
            return false;
    }

    public int	size(){
        return lista.getIndiceFim();
    }
}