package pl.ttpsc.zzp.fellowship;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.ttpsc.zzp.fellowship.creatures.*;

import java.util.Collections;
import java.util.List;


/**
 * Zadanie 1
 *
 * Przypomnienie testowania jednostkowego z assertJ wykorzystujac strukture Given-When-Then.
 *
 * Sprawdz:
 * 1. Czy w druzynie znajduje sie jakis czlowiek.
 * 2. Czy druzyna sklada sie z 9 czlonkow.
 * 3. Jakiej rasy jest czarodziej Gandalf.
 * 4. Czy w druzynie jest jakis Maiar
 * 5. Czy Balrog jest czlonkiem druzyny. - klasa Balrog
 * 6. Czy Boromir jest dokladnie pomiedzy Aragornem i Legolasem.
 * 7. Czy druzyna zawiera 4 hobbitow.
 * 8. Czy Saruman jest Valarem? - klasa Saruman
 */
class FellowshipTest implements WithAssertions {
    //TODO

    @Test
    public void WDruzynieZnajdujeSieCzlowiek()
    {
        Fellowship fellowship = new Fellowship();
        List<Creature> members =  fellowship.getMembers();
        int man_counter = 0;
        for(int i = 0; i<members.size(); i++)
        {
            if(members.get(i) instanceof Man)
            {
                man_counter += 1;
            }
        }
        assertThat(man_counter).isGreaterThan(0);
    }

    @Test
    public void DruzynaSkladaSieZ9Czlonkow()
    {
        Fellowship fellowship = new Fellowship();
        List<Creature> members =  fellowship.getMembers();
        assertThat(members.size()).isEqualTo(9);
    }

    @Test
    public void GandalfJestValarem()
    {
        Fellowship fellowship = new Fellowship();
        List<Creature> members =  fellowship.getMembers();
        Creature Gandalf = null;
        for(int i = 0; i<members.size(); i++)
        {
            if(members.get(i).getName() == "Gandalf")
            {
               Gandalf = members.get(i);
            }
        }
        assertThat(Gandalf).isInstanceOf(Valar.class);
    }
    @Test
    public void WDrużynieJestMaiar()
    {
        Fellowship fellowship = new Fellowship();
        List<Creature> members =  fellowship.getMembers();
        List<Class> members_classes = Collections.singletonList(members.getClass());
        assertThat(members_classes).contains(Maiar.class);
    }

    @Test
    public void BalrogJestCzlonkiemDruzyny()
    {
        Fellowship fellowship = new Fellowship();
        List<Creature> members =  fellowship.getMembers();
        List<Class> members_classes = Collections.singletonList(members.getClass());
        assertThat(members_classes).contains(Balrog.class);
    }

    @Test
    public void DrużynaZawiera4Hobbity()
    {
        Fellowship fellowship = new Fellowship();
        List<Creature> members =  fellowship.getMembers();
        int hobbit_counter = 0;
        for(int i=0; i<members.size(); i++)
        {
            if(members.get(i) instanceof Hobbit)
            {
                hobbit_counter+=1;
            }
        }
        assertThat(hobbit_counter).isEqualTo(4);
    }

    @Test
    public void SarumanJestValarem()
    {
        Saruman saruman = new Saruman();
        assertThat(saruman).isInstanceOf(Valar.class);
    }




}
