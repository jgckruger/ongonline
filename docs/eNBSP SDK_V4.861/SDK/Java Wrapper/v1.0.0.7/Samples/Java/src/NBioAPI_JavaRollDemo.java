import com.nitgen.SDK.BSP.NBioBSPJNI;

public class NBioAPI_JavaRollDemo extends javax.swing.JDialog {

    /** Creates new form NBioAPI_JavaRollDemo */
    public NBioAPI_JavaRollDemo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                Closing();
                System.exit(0);
            }
        });

        bsp = new NBioBSPJNI();

        if (CheckError())
            return ;

       setTitle("NBioAPI_JavaRollDemo BSP version: " + bsp.GetVersion());

       if (SetDeviceList() == false)
          return ;

       labelStatus.setText("NBioBSP Initialize success");
    }

    public Boolean CheckError()
    {
        if (bsp.IsErrorOccured())  {
            labelStatus.setText("NBioBSP Error Occured [" + bsp.GetErrorCode() + "]");
            return true;
        }

        return false;
    }

    public void dispose()
    {
        if (hSavedFIR != null)  {
            hSavedFIR.dispose();
            hSavedFIR = null;
        }

        if (bsp != null) {
            bsp.dispose();
            bsp = null;
        }
    }

    public void Closing()
    {
        dispose();
    }

    private boolean SetDeviceList()
    {
        int i, n;
        String szValue;

        deviceEnumInfo = bsp.new DEVICE_ENUM_INFO();
        bsp.EnumerateDevice(deviceEnumInfo);

        if (CheckError())  {
           btnOpen.setEnabled(false);
           return false;
        }

        n = deviceEnumInfo.DeviceCount;

        if (n == 0)  {
            labelStatus.setText("Can not find Device!!");
            btnOpen.setEnabled(false);
            return false;
        }

        szValue = "Auto_Detect";
        comboDevice.addItem(szValue);

        for (i = 0; i < n; i++)  {
            szValue = deviceEnumInfo.DeviceInfo[i].Name + "(ID: " + deviceEnumInfo.DeviceInfo[i].Instance + ") " + deviceEnumInfo.DeviceInfo[i].Description;
            comboDevice.addItem(szValue);
        }

        comboDevice.setSelectedIndex(0);
        btnOpen.setEnabled(true);
        openedDevice = 0;

        return true;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        comboDevice = new javax.swing.JComboBox();
        btnOpen = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        FPWnd = new java.awt.Canvas();
        checkFINDraw = new java.awt.Checkbox();
        btnCapture = new javax.swing.JButton();
        btnVerify = new javax.swing.JButton();
        labelStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Device Function"));

        jLabel1.setText("Roll Device List");

        btnOpen.setText("Open");
        btnOpen.setEnabled(false);
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(comboDevice, 0, 355, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(btnOpen, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 181, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(comboDevice, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnOpen))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Capture Function"));

        FPWnd.setBackground(new java.awt.Color(255, 255, 255));

        checkFINDraw.setEnabled(false);
        checkFINDraw.setLabel("Finger Image No Drawing");

        btnCapture.setText("Roll Capture Start");
        btnCapture.setEnabled(false);
        btnCapture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaptureActionPerformed(evt);
            }
        });

        btnVerify.setText("Matching Test");
        btnVerify.setEnabled(false);
        btnVerify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerifyActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(FPWnd, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 415, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(checkFINDraw, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnCapture, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                    .add(btnVerify, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(checkFINDraw, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(25, 25, 25)
                        .add(btnCapture, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 67, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 284, Short.MAX_VALUE)
                        .add(btnVerify, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 67, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(FPWnd, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        labelStatus.setText("No Error");
        labelStatus.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .add(labelStatus, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 7, Short.MAX_VALUE)
                .add(labelStatus))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
        labelStatus.setText("Device Open Method Start");

        if (openedDevice != 0)
            bsp.CloseDevice(openedDevice);

        openedDevice = 0;

        int nSelectedIndex = comboDevice.getSelectedIndex();

        if (nSelectedIndex == 0)
            bsp.OpenDevice();
        else  {
            nSelectedIndex -= 1;
            bsp.OpenDevice(deviceEnumInfo.DeviceInfo[nSelectedIndex].NameID, deviceEnumInfo.DeviceInfo[nSelectedIndex].Instance);
        }

        if (CheckError())
            return ;

        openedDevice = bsp.GetOpenedDeviceID();
        btnCapture.setEnabled(true);

        labelStatus.setText("NBioBSP OpenDevice success");
    }//GEN-LAST:event_btnOpenActionPerformed

    private void btnCaptureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaptureActionPerformed
        labelStatus.setText("Roll Capture Method Start");

        NBioBSPJNI.WINDOW_OPTION winOption;

        winOption = bsp.new WINDOW_OPTION();

        winOption.WindowStyle = NBioBSPJNI.WINDOW_STYLE.INVISIBLE;

        if (checkFINDraw.getState() == false)
            winOption.FingerWnd = FPWnd;

        if (hSavedFIR != null)  {
            hSavedFIR.dispose();
            hSavedFIR = null;
        }

        hSavedFIR = bsp.new FIR_HANDLE();

        bsp.RollCapture(NBioBSPJNI.FIR_PURPOSE.ENROLL, hSavedFIR, 10000, null, winOption);

        if (CheckError())
            return ;

        btnVerify.setEnabled(true);
        labelStatus.setText("NBioBSP RollCapture success");
    }//GEN-LAST:event_btnCaptureActionPerformed

    private void btnVerifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerifyActionPerformed
        labelStatus.setText("Verify Method Start");

        if (hSavedFIR == null)  {
            labelStatus.setText("Can not find saved FIR");
            return ;
        }

        NBioBSPJNI.INPUT_FIR inputFIR = bsp.new INPUT_FIR();
        Boolean bResult = new Boolean(false);

        inputFIR.SetFIRHandle(hSavedFIR);
        bsp.Verify(inputFIR, bResult, null);

        if (CheckError())
            return ;

        if (bResult)
            labelStatus.setText("Verify OK");
        else
            labelStatus.setText("Verify Failed");
    }//GEN-LAST:event_btnVerifyActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NBioAPI_JavaRollDemo dialog = new NBioAPI_JavaRollDemo(new javax.swing.JFrame(), true);
                dialog.setVisible(true);
            }
        });
    }

    // Variable BSP
    private NBioBSPJNI                      bsp;
    private NBioBSPJNI.DEVICE_ENUM_INFO     deviceEnumInfo;
    private short                           openedDevice;
    private NBioBSPJNI.FIR_HANDLE           hSavedFIR;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Canvas FPWnd;
    private javax.swing.JButton btnCapture;
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnVerify;
    private java.awt.Checkbox checkFINDraw;
    private javax.swing.JComboBox comboDevice;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelStatus;
    // End of variables declaration//GEN-END:variables

}
