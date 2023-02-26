package ru.neket.DAOcourse.dao;

import org.springframework.stereotype.Component;
import ru.neket.DAOcourse.models.Persone;

import java.util.ArrayList;
import java.util.List;


@Component
public class PersoneDao
{
    private static int COUNT_PERSONE;
    private List<Persone> people;

    {
        people = new ArrayList<>();
        people.add(new Persone(++COUNT_PERSONE, "Nikita"));
        people.add(new Persone(++COUNT_PERSONE, "Mariya"));
        people.add(new Persone(++COUNT_PERSONE, "Victor"));
        people.add(new Persone(++COUNT_PERSONE, "Goga"));
    }

    public List<Persone> index()
    {
        return (people);
    }

    public Persone show(int id)
    {
        for (int i = 0; i != people.size(); i ++)
        {
            if (id == people.get(i).getId())
                return (people.get(i));
            else
                continue ;
        }
        return null;
    }

    public void save(Persone persone)
    {
        persone.setId(++COUNT_PERSONE);
        people.add(persone);
    }
}
