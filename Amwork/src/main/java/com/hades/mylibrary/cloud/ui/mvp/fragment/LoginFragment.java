package com.hades.mylibrary.cloud.ui.mvp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hades.mylibrary.R;
import com.hades.mylibrary.base.projectutils.ToaUtils;
import com.hades.mylibrary.base.ui.mvp.fragment.BaseFragment;
import com.hades.mylibrary.cloud.constant.ConstantSet;
import com.hades.mylibrary.cloud.ui.mvp.presenter.LoginPresenter;
import com.hades.mylibrary.cloud.ui.mvp.view.ILoadData;


/**
 * Created by jiuzheyange on 2016/8/10.
 */
public class LoginFragment extends BaseFragment<LoginPresenter> implements ILoadData{

    View mView;
    //TextView forgetPasswordBt;
    TextView loginBt;

    ImageView qqLoginBt;
    ImageView wxLoginBt;
    ImageView wbLoginBt;

    EditText inputEmail;
    EditText inputPassword;

    LinearLayout loginBar;

    TextView tip;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_login_ly, null);

        init(mView, savedInstanceState);

        return mView;

    }


    @Override
    protected LoginPresenter onLoadPresenter() {
        return new LoginPresenter(getContext());
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
// forgetPasswordBt= (TextView) mView.findViewById(R.id.forget_password);
        loginBt = (TextView) mView.findViewById(R.id.login_bt);
        qqLoginBt = (ImageView) mView.findViewById(R.id.qq_login_bt);
        wxLoginBt = (ImageView) mView.findViewById(R.id.wx_login_bt);
        wbLoginBt = (ImageView) mView.findViewById(R.id.wb_login_bt);
        inputEmail = (EditText) mView.findViewById(R.id.input_email);
        inputPassword = (EditText) mView.findViewById(R.id.input_password);
        loginBar = (LinearLayout) mView.findViewById(R.id.login_bar);

        tip = (TextView) mView.findViewById(R.id.tip);

        if (ConstantSet.confiMap != null) {
            if (ConstantSet.confiMap.get("App.Switch.Third-Party.Login").equals("0")) {
                loginBar.setVisibility(View.GONE);
                tip.setVisibility(View.GONE);
            }
        }
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {
//        forgetPasswordBt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//                startActivity(new Intent(getActivity(), ChangePasswordActivity.class));
//            }
//        });


        loginBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!((inputEmail.getText().toString().length() > 0) && (inputPassword.getText().toString().length() > 0))) {
                    ToaUtils.showTextToast(R.string.ERROR_UNIVERSAL_PWD, getContext());
                } else {

                    loginUser(inputEmail.getText().toString(), inputPassword.getText().toString());

                }


//                 startActivity(new Intent(getActivity(), HomeActivity.class));
//                 getActivity().finish();
            }
        });


//        qqLoginBt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AuthorizedLoginUtils.authorzedQQ(getActivity());
//                Toast.makeText(getActivity(),"请稍等", Toast.LENGTH_SHORT).show();
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
////                AuthorizedLoginUtils.authorzedSina(getActivity());
////                showShortToast("请稍等");
//                getActivity().startActivity(new Intent(getActivity(),HomeActivity.class));
//                getActivity().finish();
//
//            }
//        });
    }


//


    public void loginUser(final String account, final String passwd) {
        getPresenter().Login(account, passwd);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void onInitData(String data) {

    }
}
