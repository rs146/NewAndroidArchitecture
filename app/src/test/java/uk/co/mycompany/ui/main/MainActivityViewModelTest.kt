package uk.co.mycompany.ui.main

import io.reactivex.Single
import io.reactivex.observers.TestObserver
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import uk.co.mycompany.api.model.IpAddress
import uk.co.mycompany.repository.Repository
import uk.co.mycompany.util.SchedulerProvider

/**
 * Unit test for [MainActivityViewModel].
 */
class MainActivityViewModelTest {

    @Mock
    private lateinit var mockRepository: Repository

    private val schedulerProvider = SchedulerProvider(Schedulers.trampoline(), Schedulers.trampoline())

    private lateinit var mainActivityViewModel: MainActivityViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mainActivityViewModel = MainActivityViewModel(mockRepository, schedulerProvider)
    }

    @Test
    fun showDataFromApi() {
        Mockito.`when`(mockRepository.getDataFromApi()).thenReturn(Single.just(IpAddress("20.0.0.0")))

        val testObserver = TestObserver<IpAddress>()

        mainActivityViewModel.showDataFromApi()
                .subscribe(testObserver)

        testObserver.assertNoErrors()
        testObserver.assertValue { ipAddress -> ipAddress.ip.equals("20.0.0.0") }
    }
}