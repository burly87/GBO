package gui.uebungen;

import java.util.ArrayList;

interface L
{
    void forEach(L l);
}

public class Liste implements L
{
    private static L l2;

    // private static Liste list = new Liste();

    private static ArrayList<L> list2 = new ArrayList<L>();

    public Liste(L l2)
    {
        Liste.l2 = l2;
    }

    public void add(L addList)
    {
        list2.add(addList);
    }

    @Override
    public void forEach(L l)
    {
        list2.forEach(e -> System.out.println(e));
    }

    public static void main(String[] args)
    {
        Liste liste = new Liste(l2);
    }

}
