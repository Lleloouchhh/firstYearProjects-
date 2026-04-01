import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainForm {
    private JPanel mainPanel;
    private JTextField txtInputPhoneNumber;
    private JButton btnAddContact;
    private JButton btnDeleteContact;
    private JButton btnViewContactDetails;
    private JTextField txtInputFirstName;
    private JTextField txtInputLastName;
    private JTextArea txtInputAddress;
    private JSpinner ageSpinner;
    private JRadioButton btnMale;
    private JRadioButton btnFemale;
    private JList<String> contactList;
    DefaultListModel<String> contacts;
    private PhonebookDirectory phonebookDirectory;

    {
        phonebookDirectory = new PhonebookDirectory();
        contacts = new DefaultListModel<>();
        contactList.setLayout(new BorderLayout());
        contactList.setModel(contacts);
        txtInputAddress.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        contactList.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    }


    public MainForm() {
        btnAddContact.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Contact contact = new Contact();


                //Validates first name
                try{
                    contact.setFirstName(txtInputFirstName.getText());
                }catch (IllegalArgumentException ea){
                    JOptionPane.showMessageDialog(null,ea.getMessage(),"Invalid First Name",2);
                    return;

                }

                //Validates last name
                try{
                    contact.setLastName(txtInputLastName.getText());
                }catch (IllegalArgumentException ea){
                    JOptionPane.showMessageDialog(null,ea.getMessage(),"Invalid Last Name",2);
                    return;
                }

                //Validates address
                try{
                    contact.setAddress(txtInputAddress.getText());
                }catch (IllegalArgumentException ea){
                    JOptionPane.showMessageDialog(null,ea.getMessage(),"Invalid Address",2);
                    return;
                }

                //Validates sex
                try{
                    String sex=null;
                    if(btnMale.isSelected()){
                        sex="Male";
                    }
                    if(btnFemale.isSelected()){
                        sex="Female";
                    }
                    contact.setSex(sex);
                }catch (IllegalArgumentException ea){
                    JOptionPane.showMessageDialog(null,ea.getMessage(),"Sex not yet selected",2);
                    return;
                }

                //Validates phone number
                try{
                    contact.setPhoneNumber(txtInputPhoneNumber.getText());

                }catch (IllegalArgumentException ea){
                    JOptionPane.showMessageDialog(null, ea.getMessage(), "Invalid phone number", 2);
                    return;

                }

                //validates age
                try{
                    contact.setAge(Integer.parseInt(ageSpinner.getValue().toString()));
                }catch (IllegalArgumentException ea){
                    JOptionPane.showMessageDialog(null, ea.getMessage() , "Invalid age", 2);
                    return;
                }

                //clear form when a contact object is created
                txtInputFirstName.setText("");
                txtInputLastName.setText("");
                txtInputAddress.setText("");
                btnMale.setSelected(false);
                btnFemale.setSelected(false);
                txtInputPhoneNumber.setText("");
                ageSpinner.setValue(0);

                //add contact to phoneBookDirectory
                phonebookDirectory.addContact(contact);

                //resets the contact list to make sure that the list was in alphabetical order
                contacts.removeAllElements();


                //Add all element to the contact list
                for (Contact c:phonebookDirectory.getAllContacts()){
                    String fullName = c.getLastName()+", "+ c.getFirstName();

                    contacts.addElement(fullName);

                }

            }
        });

        btnViewContactDetails.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                if(!contactList.isSelectionEmpty()){
                    int idx= contactList.getSelectedIndex();
                    JOptionPane.showMessageDialog(null, phonebookDirectory.getFullDetails(idx),"Contact full details",1 );

                }
            }
        });

        btnViewContactDetails.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);

                if(contactList.isSelectionEmpty()&&!contacts.isEmpty()){
                    JOptionPane.showMessageDialog(null,"You must select a contact on the contact List.","View contact",2);
                }
            }
        });

        btnDeleteContact.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(!contactList.isSelectionEmpty()){
                    int idx = contactList.getSelectedIndex();
                    do {
                        String option=JOptionPane.showInputDialog(null,"Are you sure you want to permanently delete? Enter \"Confirm\" to delete.");
                        if(option.isEmpty()||option==null){
                            continue;
                        }
                        if (option.equalsIgnoreCase("Confirm")){
                            contacts.remove(idx);
                            phonebookDirectory.getAllContacts().remove(idx);
                            JOptionPane.showMessageDialog(null,"Contact deleted.");
                            break;
                        }

                    }while (true);

                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if(contactList.isSelectionEmpty()&&!contacts.isEmpty()){
                    JOptionPane.showMessageDialog(null,"You must select a contact on the contact List.","Delete contact",2);
                }
            }
        });
        btnMale.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                btnFemale.setSelected(false);
            }
        });
        btnFemale.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                btnMale.setSelected(false);
            }
        });
    }

    public static void main(String[] args) {

        JFrame jFrame= new JFrame("Gui Phone Book");
        jFrame.setContentPane(new MainForm().mainPanel);
        jFrame.setSize(550,300);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);


    }
}
