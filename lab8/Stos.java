public class Stos <T>
{
    public class Node <TT>
    {
        public TT m_value;
        public Node<TT> m_next;

        Node(TT value, Node<TT> next)
        {
            m_value = value;
            m_next = next;
        }
    }

    public Node<T> peak = null;

    public void push(T value)
    {
        if(peak != null)
        {
            Node<T> tmp = peak;
            peak = new Node<T> (value, peak);
        }
        else
        {
            peak = new Node<T>(value, null);   
        }
    }

    public String toString()
    {
        if(peak != null)
        {
            String str = "";
            Node<T> tmp = peak;
            while(tmp != null)
            {
                str += "{" + tmp.m_value + "} ";
                tmp = tmp.m_next;
            }
            return str + "\n";
        }
        else
        {
         return "Nasza kopalnia złota jest niemal pusta";   
        }
    }

    public void pop()
    {
        if(peak != null)
        {
            Node<T> tmp = peak;
            peak = peak.m_next;
            tmp.m_next = null;
        }
    }


}
