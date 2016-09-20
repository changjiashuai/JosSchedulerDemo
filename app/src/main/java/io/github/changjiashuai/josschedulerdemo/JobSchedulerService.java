package io.github.changjiashuai.josschedulerdemo;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 16/9/20 17:24.
 */
public class JobSchedulerService extends JobService {

  private Handler mJobHandler = new Handler(new Handler.Callback() {
    @Override
    public boolean handleMessage(Message msg) {
      Toast.makeText(JobSchedulerService.this, "JobService task running", Toast.LENGTH_SHORT).show();
      jobFinished((JobParameters)msg.obj, false);
      return true;
    }
  });

  @Override
  public boolean onStartJob(JobParameters params) {
    mJobHandler.sendMessage(Message.obtain(mJobHandler, 1, params));
    return true;
  }

  @Override
  public boolean onStopJob(JobParameters params) {
    mJobHandler.removeMessages(1);
    return false;
  }
}
