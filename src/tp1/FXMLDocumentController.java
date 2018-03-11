/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import java.net.URL;
import java.util.ResourceBundle;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.scene.text.Text;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;




/**
 *
 * @author Tazam
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    private ResourceBundle bundle;
    private Locale locale;
    
    @FXML
    private Button button, buttonSearch;

    @FXML
    private Button buttonPosition;
    @FXML
    private Button buttonResize;
    @FXML
    private Button buttonRename;
    @FXML
    private Button buttonSlideshow;
    @FXML
    private Button buttonDirectory;
    @FXML
    private Button buttonNewKeyword;
    @FXML
    private MenuBar menuBar;
    @FXML
    private Menu menuFile;
    @FXML
    private MenuItem menuItemClose,menuItemSave;
    @FXML
    private Menu menuEdit;
    @FXML
    private MenuItem menuItemDelete;
    @FXML
    private Menu menuHelp;
    @FXML
    private MenuItem menuItemAbout;
    @FXML
    private Menu menuLanguage;
    @FXML
    private MenuItem menuItemEnglish;
    @FXML
    private MenuItem menuItemFrench;
    @FXML
    private MenuItem menuItemRussian;
    @FXML
    private ToolBar toolBar;
    @FXML
    private Tooltip tooltipLaunchSlideshow;
    @FXML
    private Tooltip tooltipChooseDirectory;
    @FXML
    private Tooltip tooltipAddKeyword;
    @FXML
    private Tooltip tooltipPosition;
    @FXML
    private Tooltip tooltipResize;
    @FXML
    private ScrollBar scrollBar;
    @FXML
    private SplitPane splitPane;
    @FXML
    private ImageView imageViewSearch;
    @FXML
    private Tooltip tooltipSearch;
    @FXML
    private ImageView imageViewPosition;
    @FXML
    private ImageView imageViewResize;
    @FXML
    private TextField textFieldImage, textFieldSearch;
    @FXML
    private Tooltip tooltipRename;
    @FXML
    private AnchorPane AnchorPanemain;
    @FXML
    private AnchorPane AnchorPaneCenter;
    @FXML
    private SplitPane SplitPaneCenter;
    @FXML
    private AnchorPane AnchorPaneViewer;
    @FXML
    private ScrollBar ScrollBarKeyWords;
    @FXML
    private VBox VBoxKeyword;
    @FXML
    private SplitPane SplitPaneKeyword;
    @FXML
    private AnchorPane AnchorPaneKeyword;
    @FXML
    private TextField TextFieldKeyword;
    @FXML
    private AnchorPane AnchorPaneFieldKeyWord;
    @FXML
    private Button buttonDeleteKeyword;
    @FXML
    private Tooltip tooltipDeleteKeyWord;
    @FXML
    private ImageView imageViewerDeleteKeyword;
    @FXML
    private Text textDirectory;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private GridPane gridPane;
    @FXML
    private ImageView mainImageView;
    
    private final DirectoryChooser directoryChooser = new DirectoryChooser();
    private PictureCollection pictureCollection;
    private String mainPicturePath;
    
    /**************************************************************************/
    /***********************HANDLERS*******************************************/
    /**************************************************************************/
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @FXML
    private void handleButtonSearch(ActionEvent event) throws FileNotFoundException {

        System.out.println("grrrrrrrrr");
        if (!textFieldSearch.getText().isEmpty())
        {
            System.out.println(pictureCollection.toString());
            ArrayList<String> pictures = pictureCollection.picturesByKeyWords(textFieldSearch.getText().split(","),textDirectory.getText());
            System.out.println(pictures.toString());
            initializePicture(pictures);
        }else
        {
            initializePicture(textDirectory.getText());
        }
        
    }
    
    @FXML
    private void handleButtonDirectory(ActionEvent event) throws FileNotFoundException {
        
        File dir = directoryChooser.showDialog(tooltipRename);
            if (dir != null) {
                textDirectory.setText(dir.getAbsolutePath());
            } else {
                textDirectory.setText(null);
            }
        initializePicture(textDirectory.getText());
    }
    
    @FXML
    private void handleButtonNewKeyword(ActionEvent event) throws FileNotFoundException {
        if ((!mainPicturePath.isEmpty())&&(!TextFieldKeyword.getText().isEmpty()))
        {
            newKeyWord(TextFieldKeyword.getText());
        }
        
    }
    
    @FXML
    private void handleMenuItemSave(ActionEvent event) throws IOException {
        pictureCollection.save();
    }
    
    @FXML
    private void handleMenuItemEnglish(ActionEvent event) {
        changeLanguage("en");
    }
    
    @FXML
    private void handleMenuItemFrench(ActionEvent event) {
        changeLanguage("fr");
    }
    
    @FXML
    private void handleMenuItemRussian(ActionEvent event) {
        changeLanguage("ru");
    }
    
    private void changeLanguage(String language){
        locale = new Locale(language); 
        bundle = ResourceBundle.getBundle("tp1.lang", locale);
        buttonSlideshow.setText(bundle.getString("buttonSlideshow"));
        buttonDirectory.setText(bundle.getString("buttonDirectory"));
        buttonRename.setText(bundle.getString("buttonRename"));
        menuFile.setText(bundle.getString("menuFile"));
        menuItemClose.setText(bundle.getString("menuItemClose"));
        menuEdit.setText(bundle.getString("menuEdit"));
        menuItemDelete.setText(bundle.getString("menuItemDelete"));
        menuHelp.setText(bundle.getString("menuHelp"));
        menuItemAbout.setText(bundle.getString("menuItemAbout"));
        menuLanguage.setText(bundle.getString("menuLanguage"));
        buttonNewKeyword.setText(bundle.getString("buttonNewKeyword"));
        TextFieldKeyword.setText(bundle.getString("TextFieldKeyword"));  
        tooltipAddKeyword.setText(bundle.getString("tooltipAddKeyword"));
        tooltipDeleteKeyWord.setText(bundle.getString("tooltipDeleteKeyWord"));
        tooltipResize.setText(bundle.getString("tooltipResize"));
        tooltipRename.setText(bundle.getString("tooltipRename"));
        tooltipPosition.setText(bundle.getString("tooltipPosition"));
        tooltipSearch.setText(bundle.getString("tooltipSearch"));

        
        
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pictureCollection = new PictureCollection();
        try {
            pictureCollection.load();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        mainPicturePath = "";
       // menuItemSave.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
    }

/******************************************************************************/
/***************************FONCTIONS UTILITAIRES******************************/
/**
     * @param path*
     * @throws java.io.FileNotFoundException***************************************************************************/
    
    public void initializePicture(String path) throws FileNotFoundException
    {
        gridPane.getChildren().clear();
        mainImageView.imageProperty().set(null);
        mainPicturePath = "";
        textFieldImage.setText("");
        VBoxKeyword.getChildren().clear();
        String IMAGE_PATTERN =  "([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)";
        Pattern pattern = Pattern.compile(IMAGE_PATTERN);
        Matcher matcher;
        File rep = new File(path);
        int i=0;
        for (String fichier : rep.list())
        {
            matcher = pattern.matcher(fichier);
            if (matcher.matches())
            {
                gridPane.addRow(i, createImageView(path+"\\"+fichier));          
            }
        }
    }
    
    public void initializePicture(ArrayList<String> pictures) throws FileNotFoundException
    {
        gridPane.getChildren().clear();
        mainImageView.imageProperty().set(null);
        textFieldImage.setText("");
        mainPicturePath = "";
        VBoxKeyword.getChildren().clear();
        int i=0;
        
        for (String picture : pictures)
        {
            gridPane.addRow(i, createImageView(picture));
            //i++;
        }
    }
    
    

    public ImageView createImageView(String path) throws FileNotFoundException
    {
        ImageView imv = new ImageView();
        Image image;
        image = new Image(new FileInputStream(path));
        imv.setImage(image);
        imv.setFitHeight(100);
        //imv.setCache(true);
        imv.setSmooth(true);
        imv.setPreserveRatio(true);
        imv.setOnMouseClicked((MouseEvent e) -> {
            try {
                mainImage(path);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        return imv;
        
    }
    
    public void mainImage(String path) throws FileNotFoundException
    {
        Image image = new Image(new FileInputStream(path));
        mainImageView.setImage(image);
        mainPicturePath = path;
        String pictureName[] = path.split("\\\\");
        textFieldImage.setText(pictureName[pictureName.length-1]);
        loadKeyWords();
    }
    
    public void loadKeyWords() throws FileNotFoundException
    {
        if (mainPicturePath.isEmpty())
            return;
        
        VBoxKeyword.getChildren().clear();
        ArrayList<String> keyWords = pictureCollection.keyWordsByPicture(mainPicturePath);
        
        if ((keyWords != null) && (!keyWords.isEmpty()))
        {
            for (String keyWord : keyWords)
            {
                keyWordLoader(keyWord);
            }
        }
        
    }
    
    private void keyWordLoader(String s) throws FileNotFoundException
    {
        SplitPane kW = new SplitPane();
        Label label1 = new Label();
        label1.setText(s);
        label1.setPrefWidth(105);
        label1.setMinWidth(105);
        Tooltip tooltip = new Tooltip();
        tooltip.setText(s);
        label1.setTooltip(tooltip);
        Button b = new Button();
        //b.getStylesheets().add("images\\croiXRouge.png");
        ImageView imV = createImageView("images\\croiXRouge.png");
        imV.setPreserveRatio(true);
        imV.setFitHeight(16);
        b.setGraphic(imV);
        b.setMinSize(25, 25);
        b.setPrefSize(25, 25);
        b.setOnMouseClicked(e->{
            try {
                deleteKeyWord(label1.getText());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
        kW.getItems().addAll(label1,b);
        kW.setDividerPositions(0.5);
        VBoxKeyword.getChildren().add(kW);
    }

    private void newKeyWord(String s) throws FileNotFoundException {
        SplitPane kW = new SplitPane();
        Label label1 = new Label();
        label1.setText(s);
        label1.setPrefWidth(105);
        label1.setMinWidth(105);
        Tooltip tooltip = new Tooltip();
        tooltip.setText(s);
        label1.setTooltip(tooltip);
        Button b = new Button();
        //b.getStylesheets().add("images\\croiXRouge.png");
        ImageView imV = createImageView("images\\croiXRouge.png");
        imV.setPreserveRatio(true);
        imV.setFitHeight(16);
        b.setGraphic(imV);
        b.setMinSize(25, 25);
        b.setPrefSize(25, 25);
        b.setOnMouseClicked(e->{
            System.out.println("delete");
            try {
                deleteKeyWord(label1.getText());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        kW.getItems().addAll(label1,b);
        kW.setDividerPositions(0.5);
        VBoxKeyword.getChildren().add(kW);
        pictureCollection.addElement(mainPicturePath, s);
    }
    
    private void deleteKeyWord(String keyWord) throws FileNotFoundException
    {
        pictureCollection.deleteKeyWord(mainPicturePath, keyWord);
        loadKeyWords();
    }
    
}

