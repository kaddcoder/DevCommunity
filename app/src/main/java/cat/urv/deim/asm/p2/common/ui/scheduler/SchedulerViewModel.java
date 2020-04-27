package cat.urv.deim.asm.p2.common.ui.scheduler;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SchedulerViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SchedulerViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is scheduler fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}