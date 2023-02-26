package ru.neket.DAOcourse.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.neket.DAOcourse.dao.PersoneDao;
import ru.neket.DAOcourse.models.Persone;

@Controller
@RequestMapping ("/people")
public class PeopleController
{
    private final PersoneDao personeDao;

    @Autowired
    public PeopleController(PersoneDao personeDao) {
        this.personeDao = personeDao;
    }

    @GetMapping ()
    public String index(Model model)
    {
        model.addAttribute("people", personeDao.index());
        return ("people/index");
    }
    @GetMapping ("/{id}")
    public String show(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("person", personeDao.show(id));
        return ("people/show");
    }
    @GetMapping("/first")
    public String lol()
    {
        return ("lol");
    }

    @GetMapping("/new")
    public String newPerson(Model model)
    {
        model.addAttribute("person", new Persone());
        return ("people/new");
    }

    @PostMapping ()
    public String create(@ModelAttribute("person") Persone persone){
        personeDao.save(persone); //Добавление объекта класса Person с помощью DAO.
        return ("redirect:/people");
    }
}
