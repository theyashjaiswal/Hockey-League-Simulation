package org.statemachine;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.leaguemodel.LoadSaveTeamToDB;
import org.leaguemodel.ValidationsInLeague;
import org.leaguemodel.interfaces.ILeague;
import org.leaguemodel.interfaces.ILeagueGetSetDB;
import org.leaguemodel.interfaces.ILoadSaveTeam;
import org.leaguemodel.interfaces.IValidationsInLeague;
import org.mockito.Mock;
import org.statemachine.interfaces.ICreate;
import org.statemachine.interfaces.IDisplay;
import org.statemachine.interfaces.IValidate;
import resources.MockData;
import resources.MockDataTrading;

import java.io.ByteArrayInputStream;

public class CreateTeamTest extends TestCase {

    @Mock
    private IValidationsInLeague iValidationsInLeague;
    private ILeagueGetSetDB leagueGetSetDB;
    private ILeague leagueLOM;
    private ILoadSaveTeam loadSaveTeam;
    private ICreate create = new CreateTeam();

    @Before
    public void setUp() throws Exception {
        leagueGetSetDB = new MockData();
        iValidationsInLeague = new ValidationsInLeague();
        leagueLOM = new MockDataTrading();
        loadSaveTeam = new LoadSaveTeamToDB();
    }

    public void userInputMock(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @Test
    public void testCreateTeam() {
        leagueGetSetDB = new MockData();
        MockDataTrading leagueLOM = new MockDataTrading();
        iValidationsInLeague = new ValidationsInLeague();
        loadSaveTeam = new LoadSaveTeamToDB();
        CreateTeam createTeam = new CreateTeam();
        userInputMock("Eastern Conference\nPacific\nRob\nSiddhant\nYash");
        createTeam.createTeam(iValidationsInLeague,leagueGetSetDB, leagueLOM.leagueOne ,loadSaveTeam);
    }

    @Test
    public void testTeamGeneralManger() {
        leagueGetSetDB = new MockData();
        IDisplay display = new Display();
        MockData leagueLOM = new MockData();
        iValidationsInLeague = new ValidationsInLeague();
        IValidate validate = new Validation();
        loadSaveTeam = new LoadSaveTeamToDB();
        Input input = new Input();
        CreateTeam createTeam = new CreateTeam();
        userInputMock("Siddhant");
        createTeam.teamGeneralManger(display, validate, leagueLOM);
    }

    @Test
    public void testTeamHeadCoach() {
        leagueGetSetDB = new MockData();
        IDisplay display = new Display();
        MockData leagueLOM = new MockData();
        iValidationsInLeague = new ValidationsInLeague();
        IValidate validate = new Validation();
        loadSaveTeam = new LoadSaveTeamToDB();
        Input input = new Input();
        CreateTeam createTeam = new CreateTeam();
        userInputMock("1");
        createTeam.teamHeadCoach(display, validate, leagueLOM);
    }
}