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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
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
    private Button button;
    @FXML
    private Button buttonSearch;
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
    private MenuItem menuItemClose;
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
    private TextField textFieldImage;
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
    
    private final DirectoryChooser directoryChooser = new DirectoryChooser();
    
    /**************************************************************************/
    /***********************HANDLERS*******************************************/
    /**************************************************************************/
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @FXML
    private void handleButtonSearch(ActionEvent event) {

    }
    
    @FXML
    private void handleButtonPosition(ActionEvent event) {

    }
    
    @FXML
    private void handleButtonResize(ActionEvent event) {

    }
    
    @FXML
    private void handleButtonRename(ActionEvent event) {

    }
    
    @FXML
    private void handleButtonSlideShow(ActionEvent event) {

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
    private void handleButtonNewKeyword(ActionEvent event) {

    }
    
    @FXML
    private void handleMenuBar(ActionEvent event) {

    }
    
    @FXML
    private void handleMenuFile(ActionEvent event) {

    }
    
    @FXML
    private void handleMenuItemClose(ActionEvent event) {

    }
    
    @FXML
    private void handleMenuEdit(ActionEvent event) {

    }
    
    @FXML
    private void handleMenuItemDelete(ActionEvent event) {

    }
    
    @FXML
    private void handleMenuHelp(ActionEvent event) {

    }
    
    @FXML
    private void handleMenuItemAbout(ActionEvent event) {

    }
    
    @FXML
    private void handleMenuLanguage(ActionEvent event) {

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
    
    @FXML
    private void handleToolBar(ActionEvent event) {

    }
    
    @FXML
    private void handleTooltipLaunchSlideShow(ActionEvent event) {

    }
    
    @FXML
    private void handleTooltipChooseDirectory(ActionEvent event) {

    }
    
    @FXML
    private void handleTooltipPosition(ActionEvent event) {

    }
    
    @FXML
    private void handleTooltipAddKeyword(ActionEvent event) {

    }
    
    @FXML
    private void handleTootipResize(ActionEvent event) {

    }
    
    @FXML
    private void handleScrollBar(ActionEvent event) {

    }
    
    @FXML
    private void handleSplitPane(ActionEvent event) {

    }
    
    @FXML
    private void handleImageViewSearch(ActionEvent event) {

    }
    
    @FXML
    private void handleTooltipSearch(ActionEvent event) {

    }
    
    @FXML
    private void handleImageViewPosition(ActionEvent event) {

    }
    @FXML
    private void handleImageViewResize(ActionEvent event) {

    }
    
    @FXML
    private void handletextFieldImage(ActionEvent event) {

    }
    
    @FXML
    private void handleTooltipRename(ActionEvent event) {

    }
    
    @FXML
    private void handleAnchorPaneMain(ActionEvent event) {

    }
    
    @FXML
    private void handleAnchorPaneCenter(ActionEvent event) {

    }
    
    @FXML
    private void handleAnchorPaneViewer(ActionEvent event) {

    }
    
    @FXML
    private void handleScrollBarKeywords(ActionEvent event) {

    }
    
    @FXML
    private void handleVBoxKeyword(ActionEvent event) {

    }
    
    @FXML
    private void handleSplitPaneKeyword(ActionEvent event) {

    }
    
    @FXML
    private void handleAnchorPaneKeyword(ActionEvent event) {

    }
    
    @FXML
    private void handleTextFieldKeyword(ActionEvent event) {

    }
    
    @FXML
    private void handleAnchorPaneFieldKeyWord(ActionEvent event) {

    }
    
    @FXML
    private void handleButtonDeleteKeyword(ActionEvent event) {

    }
    
    @FXML
    private void handleTooltipDeleteKeyWord(ActionEvent event) {

    }
    
    @FXML
    private void handleImageViewerDeleteKeyword(ActionEvent event) {

    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

/******************************************************************************/
/***************************FONCTIONS UTILITAIRES******************************/
/**
     * @param path*
     * @throws java.io.FileNotFoundException***************************************************************************/
    
    public void initializePicture(String path) throws FileNotFoundException
    {
        gridPane.getChildren().clear();
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
                //System.out.println(path+fichier);
                //createImageView(path+fichier);
                gridPane.addRow(i, createImageView(path+"\\"+fichier));
                //scrollPane.setChild(createImageView(path+fichier));
               
            }
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
        
        return imv;
        
    }
}

