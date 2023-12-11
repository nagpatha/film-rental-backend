package Service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.filmrental.repository.ActorRepo;
import com.filmrental.service.ActorServiceImpl;

@SpringBootTest
public class ActorServiceImplTest {
	
	@Mock
	ActorRepo actorRepo;
	
	@InjectMocks
	ActorServiceImpl actorServiceImpl;
	
//	@Test
	
	
	
	
}
