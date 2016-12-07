package com.hades.mylibrary.cloud.ui.mvp.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hades.mylibrary.R;
import com.hades.mylibrary.base.projectutils.ToaUtils;
import com.hades.mylibrary.base.ui.mvp.fragment.BaseFragment;
import com.hades.mylibrary.base.utils.ValidateUtils;
import com.hades.mylibrary.cloud.ui.mvp.presenter.RegistPresenter;
import com.hades.mylibrary.cloud.ui.mvp.view.ILoadData;


/**
 * Created by jiuzheyange on 2016/8/10.
 */
public class ResigterFragment extends BaseFragment<RegistPresenter> implements ILoadData {

    View mView;
    TextView nextBt;

    ImageView qqLoginBt;
    ImageView wxLoginBt;
    ImageView wbLoginBt;

    EditText inputEmail;
    EditText inputPassword1;
    EditText inputPassword2;

    EditText input_code;
    Button fetch_code;
    TimeCount time = new TimeCount(60000, 1000);


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_register_ly, null);
        init(mView, savedInstanceState);
        return mView;

    }


    @Override
    protected RegistPresenter onLoadPresenter() {
        return new RegistPresenter(getContext());
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        nextBt = (TextView) mView.findViewById(R.id.next_bt);
        qqLoginBt = (ImageView) mView.findViewById(R.id.qq_login_bt);
        wxLoginBt = (ImageView) mView.findViewById(R.id.wx_login_bt);
        wbLoginBt = (ImageView) mView.findViewById(R.id.wb_login_bt);

        inputEmail = (EditText) mView.findViewById(R.id.input_email);
        inputPassword1 = (EditText) mView.findViewById(R.id.input_password1);
        inputPassword2 = (EditText) mView.findViewById(R.id.input_password2);

        input_code = (EditText) mView.findViewById(R.id.input_code);
        fetch_code = (Button) mView.findViewById(R.id.fetch_code);


    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {
        fetch_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (inputEmail.getText().toString().trim().isEmpty()) {
                    ToaUtils.showTextToast("请输入手机号!", getActivity());
                    return;
                }
                if (!ValidateUtils.isMobileNO(inputEmail.getText().toString()) ) {
                    ToaUtils.showTextToast("请检查手机号码是否有误!", getActivity());
                    return;
                }

                fetchCode(inputEmail.getText().toString().trim());
                time.start();
            }
        });


        nextBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  startActivity(new Intent(getActivity(), SetPasswordActivity.class));
                if (inputEmail.getText().toString().trim().isEmpty()) {
                    ToaUtils.showTextToast("请输入手机号!", getActivity());
                    return;
                }
                if (!ValidateUtils.isMobileNO(inputEmail.getText().toString() ) ) {
                    ToaUtils.showTextToast("请检查手机号码是否有误!", getActivity());
                    return;
                }
                if (inputPassword1.getText().toString().isEmpty()) {
                    ToaUtils.showTextToast("请输入密码!", getActivity());
                    return;
                }
                if (inputPassword2.getText().toString().isEmpty()) {
                    ToaUtils.showTextToast("请确认密码!", getActivity());
                    return;
                }

                if (!((inputPassword1.getText().toString()).equals(inputPassword2.getText().toString()))) {
                    ToaUtils.showTextToast("两次密码输入不一致!", getActivity());
                    return;
                }
                if (input_code.getText().toString().trim().isEmpty()) {
                    ToaUtils.showTextToast("请输入验证码!", getActivity());
                    return;
                }

                {
                    ToaUtils.showTextToast("请稍等...", getActivity());
                    mPresenter.regist(inputEmail.getText().toString(), inputPassword1.getText().toString(),
                            input_code.getText().toString().trim());
                }


            }
        });


//        qqLoginBt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getActivity(), "请稍等", Toast.LENGTH_SHORT).show();
//                AuthorizedLoginUtils.authorzedQQ(getActivity());
//
//
//            }
//        });
//
//        wxLoginBt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AuthorizedLoginUtils.authorzedWechat(getActivity());
//                showShortToast("请稍等");
//            }
//        });
//
//        wbLoginBt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AuthorizedLoginUtils.authorzedSina(getActivity());
//                showShortToast("请稍等");
//            }
//        });
    }

    private void fetchCode(String mobile) {
        mPresenter.FetchCode(mobile);
    }



    @Override
    public void onInitData(String data) {
        //注册成功的回调
    }


    class TimeCount extends CountDownTimer {

        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            fetch_code.setClickable(false);
            fetch_code.setEnabled(false);
            if (isAdded()) {
                fetch_code.setTextColor(getResources().getColor(R.color.tv_universal_hintcolor));
            }
            fetch_code.setText("再次获取" + millisUntilFinished / 1000+"s");
        }

        @SuppressLint("NewApi")
        @Override
        public void onFinish() {
            fetch_code.setText("获取验证码");
            fetch_code.setClickable(true);
            fetch_code.setEnabled(true);
            fetch_code.setTextColor(getResources().getColor(R.color.tv_universal_content));
        }
    }



}
