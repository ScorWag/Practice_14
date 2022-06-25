import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Player;
import ru.netology.manager.Game;
import ru.netology.manager.NotFoundException;

public class GameTest {

    Game game = new Game();

    Player player1 = new Player(1, "Angel", 7);
    Player player2 = new Player(2, "Demon", 5);
    Player player3 = new Player(3, "Lucifer", 9);
    Player player4 = new Player(4, "Michael", 9);

    @Test
    void shouldWinFirstPlayerWithRegisteredPlayers() {

        game.register(player1);
        game.register(player2);

        int actual = game.round("Angel", "Demon");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldWinSecondPlayerWithRegisteredPlayers() {

        game.register(player1);
        game.register(player2);

        int actual = game.round("Demon", "Angel");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldBeDrawWithRegisteredPlayers() {

        game.register(player3);
        game.register(player4);

        int actual = game.round("Lucifer", "Michael");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldThrowNotFoundExceptionWithFirstUnregisteredPlayer() {

        game.register(player3);
        game.register(player4);
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotFoundException.class, () -> game.round("Gangel", "Lucifer"));
    }

    @Test
    void shouldThrowNotFoundExceptionWithSecondUnregisteredPlayer() {

        game.register(player3);
        game.register(player4);
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotFoundException.class, () -> game.round("Michael", "Icifer"));
    }

    @Test
    void shouldThrowNotFoundExceptionWithUnregisteredPlayers() {

        game.register(player3);
        game.register(player4);
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotFoundException.class, () -> game.round("Imichael", "Icifer"));
    }


}
