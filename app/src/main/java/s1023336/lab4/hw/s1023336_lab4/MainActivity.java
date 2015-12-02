package s1023336.lab4.hw.s1023336_lab4;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;
        import android.widget.RadioButton;
        import android.widget.RadioGroup;
        import java.util.Stack;
        import android.widget.Toast;
        import java.math.BigDecimal;
        import java.lang.Float;
        import android.os.Message;

        import android.content.Context;

public class MainActivity extends AppCompatActivity {

    private Button mbtn_1 , mbtn_2 , mbtn_3 , mbtn_4 , mbtn_5 ,
            mbtn_6 , mbtn_7 , mbtn_8 , mbtn_9 ,mbtn_0 , mbtn_eqal ,
            mbtn_add , mbtn_sub , mbtn_mul , mbtn_div , mbtn_clean ,
            mbtn_fac , mbtn_spc , mbtn_dot , mbtn_Exit;
    private TextView mtv_output;
    private RadioGroup mRadiogroup;
    private RadioButton mrdoBtn_dul , mrdoBtn_oct , mrdoBtn_dec;
    private static Toast mToast;
    String strTEMP = "";
    int beforeRadio = R.id.rdoBtn_dec;
    Stack<BigDecimal> rememberStack=new Stack<BigDecimal>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbtn_0 = (Button) findViewById(R.id.btn_0);
        mbtn_1 = (Button) findViewById(R.id.btn_1);
        mbtn_2 = (Button) findViewById(R.id.btn_2);
        mbtn_3 = (Button) findViewById(R.id.btn_3);
        mbtn_4 = (Button) findViewById(R.id.btn_4);
        mbtn_5 = (Button) findViewById(R.id.btn_5);
        mbtn_6 = (Button) findViewById(R.id.btn_6);
        mbtn_7 = (Button) findViewById(R.id.btn_7);
        mbtn_8 = (Button) findViewById(R.id.btn_8);
        mbtn_9 = (Button) findViewById(R.id.btn_9);

        mbtn_eqal = (Button) findViewById(R.id.btn_eqal);
        mbtn_add = (Button) findViewById(R.id.btn_add);
        mbtn_sub = (Button) findViewById(R.id.btn_sub);
        mbtn_mul = (Button) findViewById(R.id.btn_mul);
        mbtn_div = (Button) findViewById(R.id.btn_div);
        mbtn_clean = (Button) findViewById(R.id.btn_clean);
        mbtn_fac = (Button) findViewById(R.id.btn_fac);
        mbtn_spc = (Button) findViewById(R.id.btn_spc);
        mbtn_dot = (Button) findViewById(R.id.btn_dot);
        mbtn_Exit = (Button) findViewById(R.id.button);

        mtv_output = (TextView) findViewById(R.id.tv_output);
        mrdoBtn_dul = (RadioButton) findViewById(R.id.rdoBtn_dul);
        mrdoBtn_oct = (RadioButton) findViewById(R.id.rdoBtn_oct);
        mrdoBtn_dec = (RadioButton) findViewById(R.id.rdoBtn_dec);
        mRadiogroup=(RadioGroup)findViewById(R.id.radioGroup);

        mbtn_0.setOnClickListener(allNumberButton); //設定每一個按鈕的監聽者
        mbtn_1.setOnClickListener(allNumberButton);
        mbtn_2.setOnClickListener(allNumberButton);
        mbtn_3.setOnClickListener(allNumberButton);
        mbtn_4.setOnClickListener(allNumberButton);
        mbtn_5.setOnClickListener(allNumberButton);
        mbtn_6.setOnClickListener(allNumberButton);
        mbtn_7.setOnClickListener(allNumberButton);
        mbtn_8.setOnClickListener(allNumberButton);
        mbtn_9.setOnClickListener(allNumberButton);
        mbtn_dot.setOnClickListener(allNumberButton);

        mbtn_eqal.setOnClickListener(allOperatorButton);
        mbtn_add.setOnClickListener(allOperatorButton);
        mbtn_sub.setOnClickListener(allOperatorButton);
        mbtn_mul.setOnClickListener(allOperatorButton);
        mbtn_div.setOnClickListener(allOperatorButton);
        mbtn_fac.setOnClickListener(allOperatorButton);
        mbtn_spc.setOnClickListener(SpaceButton);
        mbtn_clean.setOnClickListener(CleanButton);
        mbtn_Exit.setOnClickListener(ExitButton);
        mRadiogroup.setOnCheckedChangeListener(changeradio);

    }
    private View.OnClickListener allNumberButton = new View.OnClickListener()
    {
        @Override
        public void onClick (View v)
        {   String strResult = mtv_output.getText().toString();
            if(strResult == " ")
                strResult = "";
            switch (v.getId()) {
                case R.id.btn_0:
                    strResult += getString(R.string.Zero);
                    strTEMP += getString(R.string.Zero);
                    break;
                case R.id.btn_1:
                    strResult += getString(R.string.One);
                    strTEMP += getString(R.string.One);
                    break;
                case R.id.btn_2:
                    strResult += getString(R.string.Two);
                    strTEMP += getString(R.string.Two);
                    break;
                case R.id.btn_3:
                    strResult += getString(R.string.Three);
                    strTEMP += getString(R.string.Three);
                    break;
                case R.id.btn_4:
                    strResult += getString(R.string.Four);
                    strTEMP += getString(R.string.Four);
                    break;
                case R.id.btn_5:
                    strResult += getString(R.string.Five);
                    strTEMP += getString(R.string.Five);
                    break;
                case R.id.btn_6:
                    strResult += getString(R.string.Six);
                    strTEMP += getString(R.string.Six);
                    break;
                case R.id.btn_7:
                    strResult += getString(R.string.Seven);
                    strTEMP += getString(R.string.Seven);
                    break;
                case R.id.btn_8:
                    strResult += getString(R.string.Eight);
                    strTEMP += getString(R.string.Eight);
                    break;
                case R.id.btn_9:
                    strResult += getString(R.string.Nine);
                    strTEMP += getString(R.string.Nine);
                    break;
                case R.id.btn_dot:
                    strResult += getString(R.string.Dot);
                    strTEMP += getString(R.string.Dot);
                    break;
            }
            mtv_output.setText(strResult);
        }

    };
    private View.OnClickListener allOperatorButton = new View.OnClickListener()
    {
        public void onClick (View v) {
            String strResult = mtv_output.getText().toString();
            specialCaculate Spaciel = new specialCaculate(getApplication());
            BigDecimal answer = new BigDecimal(0);
            BigDecimal zero = new BigDecimal(0);
            BigDecimal NintyNine = new BigDecimal(100);
            if (!strResult.isEmpty() && !rememberStack.isEmpty())
                try{
                    answer = rememberStack.pop();
                    switch (v.getId()) {
                        case R.id.btn_add:
                            if(mrdoBtn_dec.isChecked())
                            {
                                answer = rememberStack.pop().add(answer);
                            }
                            else if(mrdoBtn_dul.isChecked())
                            {
                                answer = BigDecimal.valueOf(Long.parseLong( Spaciel.BinarytoDecimal(rememberStack.pop().toString()))).add(BigDecimal.valueOf(Long.parseLong( Spaciel.BinarytoDecimal(answer.toString()))));//二轉成十進位
                                answer = BigDecimal.valueOf(Long.parseLong(Spaciel.DecimaltoBinary(answer.toString())));
                            }
                            else if (mrdoBtn_oct.isChecked())
                            {
                                answer = BigDecimal.valueOf(Long.parseLong( Spaciel.OctaltoDecimal(rememberStack.pop().toString()))).add(BigDecimal.valueOf(Long.parseLong( Spaciel.OctaltoDecimal(answer.toString()))));//二轉成十進位
                                answer = BigDecimal.valueOf(Long.parseLong(Spaciel.DecimaltoOctal(answer.toString())));
                            }
                            strResult += getString(R.string.Add);
                            rememberStack.push(answer);
                            break;
                        case R.id.btn_sub:
                            if(mrdoBtn_dec.isChecked())
                            {
                                answer = rememberStack.pop().subtract(answer);
                            }
                            else if(mrdoBtn_dul.isChecked())
                            {
                                answer = BigDecimal.valueOf(Long.parseLong( Spaciel.BinarytoDecimal(rememberStack.pop().toString()))).subtract(BigDecimal.valueOf(Long.parseLong(Spaciel.BinarytoDecimal(answer.toString()))));//二轉成十進位
                                answer = BigDecimal.valueOf(Long.parseLong(Spaciel.DecimaltoBinary(answer.toString())));
                            }
                            else if (mrdoBtn_oct.isChecked())
                            {
                                answer = BigDecimal.valueOf(Long.parseLong( Spaciel.OctaltoDecimal(rememberStack.pop().toString()))).subtract(BigDecimal.valueOf(Long.parseLong(Spaciel.OctaltoDecimal(answer.toString()))));//二轉成十進位
                                answer = BigDecimal.valueOf(Long.parseLong(Spaciel.DecimaltoOctal(answer.toString())));
                            }
                            strResult += getString(R.string.sub);
                            rememberStack.push(answer);
                            break;
                        case R.id.btn_mul:
                            if(mrdoBtn_dec.isChecked())
                            {
                                answer = rememberStack.pop().multiply(answer);
                            }
                            else if(mrdoBtn_dul.isChecked())
                            {
                                answer = BigDecimal.valueOf(Long.parseLong( Spaciel.BinarytoDecimal(rememberStack.pop().toString()))).multiply(BigDecimal.valueOf(Long.parseLong(Spaciel.BinarytoDecimal(answer.toString()))));//二轉成十進位
                                answer = BigDecimal.valueOf(Long.parseLong(Spaciel.DecimaltoBinary(answer.toString())));
                            }
                            else if (mrdoBtn_oct.isChecked())
                            {
                                answer = BigDecimal.valueOf(Long.parseLong( Spaciel.OctaltoDecimal(rememberStack.pop().toString()))).multiply(BigDecimal.valueOf(Long.parseLong(Spaciel.OctaltoDecimal(answer.toString()))));//二轉成十進位
                                answer = BigDecimal.valueOf(Long.parseLong(Spaciel.DecimaltoOctal(answer.toString())));
                            }
                            strResult += getString(R.string.mul);
                            rememberStack.push(answer);
                            break;
                        case R.id.btn_div:
                            if(answer.compareTo(zero) != 0) {
                                if (mrdoBtn_dec.isChecked()) {
                                    answer = new BigDecimal(Spaciel.trim(rememberStack.pop().divide(answer, 8, BigDecimal.ROUND_DOWN).toString()));
                                } else if (mrdoBtn_dul.isChecked()) {
                                    answer = BigDecimal.valueOf(Long.parseLong(Spaciel.BinarytoDecimal(rememberStack.pop().toString()))).divide(BigDecimal.valueOf(Long.parseLong(Spaciel.BinarytoDecimal(answer.toString()))), 0, BigDecimal.ROUND_DOWN);//二轉成十進位
                                    answer = BigDecimal.valueOf(Long.parseLong(Spaciel.DecimaltoBinary(answer.toString())));
                                } else if (mrdoBtn_oct.isChecked()) {
                                    answer = BigDecimal.valueOf(Long.parseLong(Spaciel.OctaltoDecimal(rememberStack.pop().toString()))).divide(BigDecimal.valueOf(Long.parseLong(Spaciel.OctaltoDecimal(answer.toString()))), 0, BigDecimal.ROUND_DOWN);//二轉成十進位
                                    answer = BigDecimal.valueOf(Long.parseLong(Spaciel.DecimaltoOctal(answer.toString())));
                                }
                                strResult += getString(R.string.div);
                                rememberStack.push(answer);
                            }
                            else
                            {
                                if(mToast != null) {
                                    mToast.cancel();
                                    mToast = null;
                                }
                                else {
                                    mToast = Toast.makeText(getApplication(), R.string.ERRORSentence, Toast.LENGTH_SHORT);
                                    mToast.show();
                                }
                                rememberStack.push(answer);
                            }
                            break;
                        case R.id.btn_eqal:
                            if(rememberStack.isEmpty()) {
                                strResult = getString(R.string.RealClean);
                                strResult += answer.toString();
                                strTEMP = strResult;
                            }
                            else
                            {
                                if(mToast != null) {
                                    mToast.cancel();
                                    mToast = null;
                                }
                                else {
                                    mToast = Toast.makeText(getApplication(), R.string.ERRORSentence, Toast.LENGTH_SHORT);
                                    mToast.show();
                                }
                                rememberStack.push(answer);
                            }
                            break;
                        case R.id.btn_fac:
                            strResult += getString(R.string.Exclamation);
                            strResult += getString(R.string.equal);
                            if(answer.compareTo(NintyNine) == -1)
                                strResult += String.format("%E", Spaciel.rfc(answer));
                            else
                                strResult = "溢位!";
                            strTEMP = strResult;
                            break;
                        default:
                            rememberStack.push(answer);
                    }
                    mtv_output.setText(strResult);//
                }
                catch(Exception e)
                {
                    if(mToast != null) {
                        mToast.cancel();
                        mToast = null;
                    }
                    else {
                        mToast = Toast.makeText(getApplication(), R.string.ERRORSentence, Toast.LENGTH_SHORT);
                        mToast.show();
                    }
                    rememberStack.push(answer);
                }
        }
    };
    private View.OnClickListener CleanButton;

    {
        CleanButton = new View.OnClickListener() {
            public void onClick(View v) {
                strTEMP = "";
                mtv_output.setText(" ");
                rememberStack.clear();
            }
        };
    }

    private View.OnClickListener SpaceButton = new View.OnClickListener()
    {
        public void onClick (View v) {
            String strResult = mtv_output.getText().toString();
            Message msg = new Message();
            msg.what = 0;
            try{
                switch(v.getId()) {
                    case R.id.btn_spc:
                        BigDecimal iResult = new BigDecimal(strTEMP);
                        rememberStack.push(iResult);
                        if (strTEMP != "")
                            strResult += getString(R.string.RealSpace);
                        strTEMP = "";
                        mtv_output.setText(strResult);
                        break;
                }
            }
            catch(Exception e)
            {
                if(mToast != null) {
                    mToast.cancel();
                    mToast = null;
                }
                else {
                    mToast = Toast.makeText(getApplication(), R.string.ERRORSentence, Toast.LENGTH_SHORT);
                    mToast.show();
                }
            }
        }
    };
    private View.OnClickListener ExitButton = new View.OnClickListener()
    {
        public void onClick (View v) {
            android.os.Process.killProcess(android.os.Process.myPid());
        }
    };
    private RadioGroup.OnCheckedChangeListener changeradio=new RadioGroup.OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            specialCaculate Spaciel = new specialCaculate(getApplication());
            String strResult = mtv_output.getText().toString();
            switch (checkedId) {
                case R.id.rdoBtn_dul://二進位
                    if(beforeRadio == R.id.rdoBtn_dec && strResult != "")strResult = Spaciel.DecimaltoBinary(strTEMP);
                    if(beforeRadio == R.id.rdoBtn_oct && strResult != "")strResult = Spaciel.OctaltoBinary(strTEMP);
                    mbtn_dot.setEnabled(false);
                    mbtn_fac.setEnabled(false);
                    mbtn_2.setEnabled(false);
                    mbtn_3.setEnabled(false);
                    mbtn_4.setEnabled(false);
                    mbtn_5.setEnabled(false);
                    mbtn_6.setEnabled(false);
                    mbtn_7.setEnabled(false);
                    mbtn_8.setEnabled(false);
                    mbtn_9.setEnabled(false);
                    beforeRadio = R.id.rdoBtn_dul;
                    break;
                case R.id.rdoBtn_oct://八進位
                    if(beforeRadio == R.id.rdoBtn_dul && strResult != "")strResult = Spaciel.BinarytoOctal(strTEMP);
                    if(beforeRadio == R.id.rdoBtn_dec && strResult != "")strResult = Spaciel.DecimaltoOctal(strTEMP);
                    mbtn_fac.setEnabled(false);
                    mbtn_dot.setEnabled(false);
                    mbtn_2.setEnabled(true);
                    mbtn_3.setEnabled(true);
                    mbtn_4.setEnabled(true);
                    mbtn_5.setEnabled(true);
                    mbtn_6.setEnabled(true);
                    mbtn_7.setEnabled(true);
                    mbtn_8.setEnabled(false);
                    mbtn_9.setEnabled(false);
                    beforeRadio = R.id.rdoBtn_oct;
                    break;
                case R.id.rdoBtn_dec://十進位
                    if(beforeRadio == R.id.rdoBtn_dul && strResult != "")strResult = Spaciel.BinarytoDecimal(strTEMP);
                    if(beforeRadio == R.id.rdoBtn_oct && strResult != "")strResult = Spaciel.OctaltoDecimal(strTEMP);
                    mbtn_dot.setEnabled(true);
                    mbtn_fac.setEnabled(true);
                    mbtn_2.setEnabled(true);
                    mbtn_3.setEnabled(true);
                    mbtn_4.setEnabled(true);
                    mbtn_5.setEnabled(true);
                    mbtn_6.setEnabled(true);
                    mbtn_7.setEnabled(true);
                    mbtn_8.setEnabled(true);
                    mbtn_9.setEnabled(true);
                    beforeRadio = R.id.rdoBtn_dec;
                    break;
            }
            strTEMP = strResult;
            rememberStack.clear();
            mtv_output.setText(strResult);
        }
    };
}
class specialCaculate {
    // 宣告大數，初始值為 1
    private BigDecimal one = new BigDecimal("1");
    private static Toast mToast;
    private static Context context;
    public specialCaculate(Context c) {
        context = c;
    }
    public  String trim(String str) {
        if (str.indexOf(".") != -1 && str.charAt(str.length() - 1) == '0') {
            return trim(str.substring(0, str.length() - 1));
        } else {
            return str.charAt(str.length() - 1) == '.' ? str.substring(0, str.length() - 1) : str;
        }
    }
    public BigDecimal rfc(BigDecimal N)
    {
        if (N.compareTo(one) == -1 || N.compareTo(one) == 0)
            return one;
        else
            return N.multiply(rfc(N.subtract(one)));
    }
    public Float round(Float value, int scale, int roundingMode) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(scale, roundingMode);
        Float d = bd.floatValue();
        bd = null;
        return d;
    }
    public String BinarytoDecimal (String num)
    {   try{
        if(num == "")
            return "";
        int BeforePoint = 0;
        if(num.indexOf('.') > 0)
            BeforePoint = Integer.parseInt(num.substring(0, num.indexOf('.')),2);
        else
            BeforePoint = Integer.parseInt(num.substring(0),2);
        String answer = Integer.toString(BeforePoint);
        return answer;
    }
    catch(Exception e)
    {
        if(mToast != null) {
            mToast.cancel();
            mToast = null;
        }
        else {
            mToast = Toast.makeText(context, R.string.ERRORSentence, Toast.LENGTH_SHORT);
            mToast.show();
        }
        return "";
    }
    }
    public String BinarytoOctal (String num)
    {
        try{
            String answer = "";
            String[]  s8  =  {  "0",  "1",  "2",  "3",  "4",  "5",  "6",  "7"  };
            String[]  s2  =  {  "000",  "001",  "010",  "011",  "100",  "101",  "110",  "111"  };
            int  chang  =  num.length();
            String[]  xian  =  new  String[chang];
            while(chang%3 != 0){
                num = "0" + num;
                chang  =  num.length();
            }

            for  (int  i  =  0;  i  <  chang; i = i + 3)
                for  (int  j  =  0;  j  <  s2.length;  j++)  {
                    if  (num.substring(i,  i  +  3).equals(s2[j]))  {//  印出計算結果
                        answer  +=  s8[j];//  儲存答案
                    }
                }
            return answer;
        }
        catch(Exception e)
        {
            if(mToast != null) {
                mToast.cancel();
                mToast = null;
            }
            else {
                mToast = Toast.makeText(context, R.string.ERRORSentence, Toast.LENGTH_SHORT);
                mToast.show();
            }
            return "";
        }
    }
    public String DecimaltoBinary (String num)
    {
        try{
            if(num == "")
                return "";
            int BeforePoint = 0;
            if(num.indexOf('.') == 0)
                BeforePoint = 0;
            else if(num.indexOf('.') > 0)
                BeforePoint = Integer.parseInt(num.substring(0, num.indexOf('.')));
            else
                BeforePoint = Integer.parseInt(num.substring(0));
            String answer = Integer.toBinaryString(BeforePoint);
            return answer;
        }
        catch(Exception e)
        {
            if(mToast != null) {
                mToast.cancel();
                mToast = null;
            }
            else {
                mToast = Toast.makeText(context, R.string.ERRORSentence, Toast.LENGTH_SHORT);
                mToast.show();
            }
            return "";
        }
    }
    public String DecimaltoOctal (String num)
    {
        try{
            if(num == "")
                return "";
            int BeforePoint = 0;
            if(num.indexOf('.') == 0)
                BeforePoint = 0;
            else if(num.indexOf('.') > 0)
                BeforePoint = Integer.parseInt(num.substring(0, num.indexOf('.')));
            else
                BeforePoint = Integer.parseInt(num.substring(0));
            String answer = Integer.toOctalString(BeforePoint);
            return answer;
        }
        catch(Exception e)
        {
            if(mToast != null) {
                mToast.cancel();
                mToast = null;
            }
            else {
                mToast = Toast.makeText(context, R.string.ERRORSentence, Toast.LENGTH_SHORT);
                mToast.show();
            }
            return "";
        }
    }
    public String OctaltoDecimal (String num)
    {   try{
        if(num == "")
            return "";
        int BeforePoint = 0;
        if(num.indexOf('.') > 0)
            BeforePoint = Integer.parseInt(num.substring(0, num.indexOf('.')),8);
        else
            BeforePoint = Integer.parseInt(num.substring(0),8);
        String answer = Integer.toString(BeforePoint);
        return answer;
    }
    catch(Exception e)
    {
        if(mToast != null) {
            mToast.cancel();
            mToast = null;
        }
        else {
            mToast = Toast.makeText(context, R.string.ERRORSentence, Toast.LENGTH_SHORT);
            mToast.show();
        }
        return "";
    }
    }
    public String OctaltoBinary (String num)
    {
        try{
            String[]  s8  =  {  "0",  "1",  "2",  "3",  "4",  "5",  "6",  "7"  };
            String[]  s2  =  {  "000",  "001",  "010",  "011",  "100",  "101",  "110",  "111"  };
            int  chang  =  num.length();
            String[]  xian  =  new  String[chang];
            String answer = "";

            for  (int  i  =  0;  i  <  chang; i++)
                for  (int  j  =  0;  j  <  s2.length;  j++)  {
                    if  (num.substring(i,  i  +  1).equals(s8[j]))  {//  印出計算結果
                        answer  +=  s2[j];//  儲存答案
                    }
                }
            return answer;
        }
        catch(Exception e)
        {
            if(mToast != null) {
                mToast.cancel();
                mToast = null;
            }
            else {
                mToast = Toast.makeText(context, R.string.ERRORSentence, Toast.LENGTH_SHORT);
                mToast.show();
            }
            return "";
        }
    }
}
