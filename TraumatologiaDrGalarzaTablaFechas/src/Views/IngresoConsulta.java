/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controller.MainController;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Dell
 */
public class IngresoConsulta extends javax.swing.JFrame {
    ArrayList datosPaciente = new ArrayList<>();
    String numDiasTexto = null;
    String proximaConsulta =null;
   
    DefaultTableModel datos = new DefaultTableModel();
    DefaultTableModel fechas = new DefaultTableModel();
    String s = "";
    int contador = 0;
    //VARIABLE DEL LISTENER PARA LA BUSQUEDA AUTOMATIZADA
   // Vector originalTableModel;
    //DocumentListener documentListener;
    //Upload de archivos
    File archivo;
    
    public IngresoConsulta() {
           
        initComponents();
        
        
        //LLENADO DE TABLA CON LOS DIAGNÓSTICOS
            datos = (DefaultTableModel) tblDiagnostico.getModel();   
            datos.addRow(new Object[]{"Coxartrosis unilateral"});
            datos.addRow(new Object[] {"Coxartrosis bilateral"});
            datos.addRow(new Object[] {"Gonortrosis unilateral"});
            datos.addRow(new Object[] {"Gonortrosis bilateral"});
            datos.addRow(new Object[] {"Deformación congénita de la cadera"});
            datos.addRow(new Object[] {"Espina bífida"});
            datos.addRow(new Object[] {"Espina bífida oculta"});
            datos.addRow(new Object[] {"Luxación congénita de cadera unilateral"});
            datos.addRow(new Object[] {"Luxación congénita de cadera bilateral"});
            datos.addRow(new Object[] {"Subluxación congénita de cadera unilateral"});
            datos.addRow(new Object[] {"Subluxación congénita de cadera bilateral"});
            datos.addRow(new Object[] {"Cadera inestable"});
            datos.addRow(new Object[] {"Deformidades congenitas de los pies"});
            datos.addRow(new Object[] {"Pie plano congenito"});
            datos.addRow(new Object[] {"Pie cavus"});
            datos.addRow(new Object[] {"Polidactilea"});
            datos.addRow(new Object[] {"Sindactilea"});
            datos.addRow(new Object[] {"Tumor maligno de huesos y cartílagos articulares de meniscos"});
            datos.addRow(new Object[] {"Tumor benigno de hueso y cartílago"});
            datos.addRow(new Object[] {"Tumor benigno lipomatoso"});
            datos.addRow(new Object[] {"Hemangioma y lifangioma de cualquier sitio"});
            datos.addRow(new Object[] {"Diabetes mellitus insulinodependientes"});
            datos.addRow(new Object[] {"Diabetes mellitus no insulinodependientes"}); 
            datos.addRow(new Object[] {"Dindrome de cushing"});
            datos.addRow(new Object[] {"Obesidad"});
            datos.addRow(new Object[] {"Epilepsia"});
            datos.addRow(new Object[] {"Hemiplejia"});
            datos.addRow(new Object[] {"Paraplejia y cuadriplejia"});
            datos.addRow(new Object[] {"Hipertensión esencial"});
            datos.addRow(new Object[] {"Hipertensión secundaria"});
            datos.addRow(new Object[] {"Varices"});
            datos.addRow(new Object[] {"Absceso cutaneo"});
            datos.addRow(new Object[] {"Celulitis"});
            datos.addRow(new Object[] {"Varices"}); 
            datos.addRow(new Object[] {"Artritis piogena"});
            datos.addRow(new Object[] {"Artritis reumatoide seropositiva"}); 
            datos.addRow(new Object[] {"Gota"}); 
            datos.addRow(new Object[] {"Poliartrosis"}); 
            datos.addRow(new Object[] {"Otras artrosis"}); 
            datos.addRow(new Object[] {"Cifosis y lordosis"});
            datos.addRow(new Object[] {"Escoliosis"});
            datos.addRow(new Object[] {"Espondilitis anquilosante"});
            datos.addRow(new Object[] {"Espondilosis"});
            datos.addRow(new Object[] {"Trastornos de disco cervical"});
            datos.addRow(new Object[] {"Dorsalgia"});
            datos.addRow(new Object[] {"Miositis"});
            datos.addRow(new Object[] {"Sinovitis y tenosinovitis"});
            datos.addRow(new Object[] {"Ruptura espontánea de la sinovial y del tendón"});
            datos.addRow(new Object[] {"Otras bursoramas"});
            datos.addRow(new Object[] {"Osteoporosis con fractura patologica"});
            datos.addRow(new Object[] {"Osteoporosis sin fractura"});
            datos.addRow(new Object[] {"Osteomielitis"});
            datos.addRow(new Object[] {"Osteonecrosis"});
            datos.addRow(new Object[] {"Enfermedad de paget de los huesos"});
            datos.addRow(new Object[] {"Malformaciones congénitas de la columna vertebral y tórax óseo"});
            datos.addRow(new Object[] {"Gangrena"});
            datos.addRow(new Object[] {"Anormalidades de la marcha y de la movilidad"});
            datos.addRow(new Object[] {"Cefalea"});
            datos.addRow(new Object[] {"Convulsiones"});
            datos.addRow(new Object[] {"Hemorragia"});
            datos.addRow(new Object[] {"Edema"});
            datos.addRow(new Object[] {"Fiebre reumática"});
            datos.addRow(new Object[] {"Flebitis tromfeblitis"});
            datos.addRow(new Object[] {"Tumefacción"});
            datos.addRow(new Object[] {"Esguince de tobillo"});
            datos.addRow(new Object[] {"Tórax en quilla"});
            datos.addRow(new Object[] {"Síndrome de túnel carpiano"});
            datos.addRow(new Object[] {"Fascitis plantar"});
            datos.addRow(new Object[] {"Espondiloartrosis"});
            datos.addRow(new Object[] {"Hematoma"});
            datos.addRow(new Object[] {"Traumatismo superficial de la nariz"});
            datos.addRow(new Object[] {"Traumatismos superficiales multiples de la cabeza"});
            datos.addRow(new Object[] {"Herida del cuero cabelludo"});
            datos.addRow(new Object[] {"Herida del párpado y de la región periocular"});
            datos.addRow(new Object[] {"Herida de la nariz"});
            datos.addRow(new Object[] {"Herida del oido"});
            datos.addRow(new Object[] {"Heridas multiples de la cabeza"});
            datos.addRow(new Object[] {"Fractura de los huesos de la nariz"});
            datos.addRow(new Object[] {"Fractura de otros huesos del cráneo y de la cara"});
            datos.addRow(new Object[] {"Traumatismo cerebral difuso"});
            datos.addRow(new Object[] {"Otros traumatismos intracraneales"});
            datos.addRow(new Object[] {"Otros traumatismos superficiales y los no especificados de la garganta"});
            datos.addRow(new Object[] {"Luxación, esguince y torcedura de articulaciones y ligamentos del cuello"});
            datos.addRow(new Object[] {"Luxación de vértebra cervical"});
            datos.addRow(new Object[] {"Esguinces y torceduras de la columna cervical"});
            datos.addRow(new Object[] {"Herida de la parte anterior del torax"});
            datos.addRow(new Object[] {"Herida de la parte posterior del torax"});
            datos.addRow(new Object[] {"Fractura de vértebra torácica"});
            datos.addRow(new Object[] {"Fracturas múltiples de columna torácica"});
            datos.addRow(new Object[] {"Fracturas del esternón"});
            datos.addRow(new Object[] {"Fractura de costilla"});
            datos.addRow(new Object[] {"Fracturas múltiples de costillas"});
            datos.addRow(new Object[] {"Fractura de otras partes del tórax óseo"});
            datos.addRow(new Object[] {"Fractura del tórax óseo parte no especificada"});
            datos.addRow(new Object[] {"Luxación, esguince y torcedura de articulaciones y ligamentos del tórax"});
            datos.addRow(new Object[] {"Ruptura traumática de disco intervertebral torácico"});
            datos.addRow(new Object[] {"Luxación de vértebra torácica"});
            datos.addRow(new Object[] {"Esguinces y torceduras de columa torácica"});
            datos.addRow(new Object[] {"Esguinces y torceduras de costilla y esternón"});
            datos.addRow(new Object[] {"Traumatismo de nervios periféricos del tórax"});
            datos.addRow(new Object[] {"Traumatismo de nervios simpáticos torácicos"});
            datos.addRow(new Object[] {"Traumatismo de otros nervios del tórax"});
            datos.addRow(new Object[] {"Traumatismo de nervio no especificado del tórax"});
            datos.addRow(new Object[] {"Aplastamiento del tórax"});
            datos.addRow(new Object[] {"Contusión de la región lumbosacra y de la pelvis"});
            datos.addRow(new Object[] {"Traumatismos superficiales múltiples del abdomen, de la región lumbosacra y de la pelvis"});
            datos.addRow(new Object[] {"Herida del abdomen, de la región lumbosacra y de la pelvis"});
            datos.addRow(new Object[] {"Herida de la región lumbosacra y de la pelvis"});
            datos.addRow(new Object[] {"Fractura de vértebra lumbar"});
            datos.addRow(new Object[] {"Fractura del sacro"});
            datos.addRow(new Object[] {"Fractura del hueso iliaco"});
            datos.addRow(new Object[] {"Fractura del acetábulo"});
            datos.addRow(new Object[] {"Fractura del pubis"});
            datos.addRow(new Object[] {"Luxación, esguince y torcedura de articulaciones y ligamentos de la columna lumbar y de la pelvis"});
            datos.addRow(new Object[] {"Ruptura traumática de disco intervertebral lumbar"});
            datos.addRow(new Object[] {"Luxación de vértebra lumbar"});
            datos.addRow(new Object[] {"Luxación de articulación sacrococcígea y sacroiliaca"});
            datos.addRow(new Object[] {"Ruptura traumática de la sínfisis del pubis"});
            datos.addRow(new Object[] {"Esguinces y torceduras de la columna lumbar"});
            datos.addRow(new Object[] {"Esguinces y torceduras de la articulación sacroiliaca"});
            datos.addRow(new Object[] {"Concusión y edema de la médula espinal lumbar"});
            datos.addRow(new Object[] {"Traumatismo de la cola de caballo"});
            datos.addRow(new Object[] {"Traumatismo del plexo lumbosacro"});
            datos.addRow(new Object[] {"Traumatismo de nervios simpáticos lumbares, sacros y pélvicos"});
            datos.addRow(new Object[] {"Traumatismo de nervios periféricos del abdomen, de la región lumbosacra y de la pelvis"});
            datos.addRow(new Object[] {"Contusión del hombro y del brazo"});
            datos.addRow(new Object[] {"Traumatismos superficiales múltiples del hombro y del brazo"});
            datos.addRow(new Object[] {"Otros traumatismos superficiales del hombro y del brazo"});
            datos.addRow(new Object[] {"Herida del hombro y del brazo"});
            datos.addRow(new Object[] {"Herida del brazo"});
            datos.addRow(new Object[] {"Heridas múltiples del hombro y del brazo"});
            datos.addRow(new Object[] {"Fractura del hombro y del brazo"});
            datos.addRow(new Object[] {"Fractura de la clavícula"});
            datos.addRow(new Object[] {"Fractura del omóplato"});
            datos.addRow(new Object[] {"Fractura de la epífisis superior del húmero"});
            datos.addRow(new Object[] {"Fractura de la diáfisis del húmero"});
            datos.addRow(new Object[] {"Fractura de la epífisis inferior del húmero"});
            datos.addRow(new Object[] {"Fracturas múltiples de la clavícula, del omóplato y del húmero"});
            datos.addRow(new Object[] {"Luxación, esguince y torcedura de articulaciones y ligamentos de la cintura escapular"});
            datos.addRow(new Object[] {"Luxación de la articulación del hombro"});
            datos.addRow(new Object[] {"Luxación de la articulación acromioclavicular"});
            datos.addRow(new Object[] {"Luxación de la articulación esternoclavicular"});
            datos.addRow(new Object[] {"Esguinces y torceduras de la articulación del hombro"});
            datos.addRow(new Object[] {"Esguinces y torceduras de la articulación acromioclavicular"});
            datos.addRow(new Object[] {"Esguinces y torceduras de la articulación esternoclavicular"});
            datos.addRow(new Object[] {"Traumatismo del nervio cubital a nivel del brazo"});
            datos.addRow(new Object[] {"Traumatismo del nervio mediano a nivel del brazo"});
            datos.addRow(new Object[] {"Traumatismo del nervio radial a nivel del brazo"});
            datos.addRow(new Object[] {"Traumatismo del nervio axilar"});
            datos.addRow(new Object[] {"Traumatismo del nervio musculocutáneo"});
            datos.addRow(new Object[] {"Traumatismo del nervio sensitivo cutáneo a nivel del hombro y del brazo"});
            datos.addRow(new Object[] {"Traumatismo de múltiples nervios a nivel del hombro y del brazo"});
            datos.addRow(new Object[] {"Traumatismo de nervio no especificado a nivel del hombro y del brazo"});
            datos.addRow(new Object[] {"Traumatismo del tendón del manguito rotatorio del brazo"});
            datos.addRow(new Object[] {"Traumatismo del tendón y músculo de otras partes del bícep"});
            datos.addRow(new Object[] {"Traumatismo de múltiples tendones y músculos a nivel del hombro y del brazo"});
            datos.addRow(new Object[] {"Traumatismo por aplastamiento del hombro y del brazo"});
            datos.addRow(new Object[] {"Amputación traumática del hombro y del brazo"});
            datos.addRow(new Object[] {"Amputación traumática en la articulación del hombro"});
            datos.addRow(new Object[] {"Amputación traumática a nivel entre el hombro y el codo"});
            datos.addRow(new Object[] {"Amputación traumática del hombro y del brazo, nivel no especificado"});
            datos.addRow(new Object[] {"Contusión del codo"});
            datos.addRow(new Object[] {"Traumatismos superficiales múltiples del antebrazo"});
            datos.addRow(new Object[] {"Otros traumatismos superficiales del antebrazo"});
            datos.addRow(new Object[] {"Herida del codo"});
            datos.addRow(new Object[] {"Heridas múltiples del antebrazo"});
            datos.addRow(new Object[] {"Herida del antebrazo parte no especificada"});
            datos.addRow(new Object[] {"Fractura de la epífisis superior del cúbito"});
            datos.addRow(new Object[] {"Fractura de la epífisis superior del radio"});
            datos.addRow(new Object[] {"Fractura de la diáfisis del cúbito"});
            datos.addRow(new Object[] {"Fractura de la diáfisis del radio"});
            datos.addRow(new Object[] {"Fractura de la diáfisis del cúbito y del radio"});
            datos.addRow(new Object[] {"Fractura de la epífisis inferior del radio"});
            datos.addRow(new Object[] {"Fractura de la epífisis inferior del cúbito y del radio"});
            datos.addRow(new Object[] {"Fracturas múltiples del antebrazo"});
            datos.addRow(new Object[] {"Luxación de la cabeza del radio"});
            datos.addRow(new Object[] {"Luxación del codo"});
            datos.addRow(new Object[] {"Ruptura traumática del ligamento lateral del radio"});
            datos.addRow(new Object[] {"Ruptura traumática del ligamento lateral del cúbito"});
            datos.addRow(new Object[] {"Esguinces y torceduras del codo"});
            datos.addRow(new Object[] {"Traumatismo del nervio cubital a nivel del antebrazo"});
            datos.addRow(new Object[] {"Traumatismo del nervio mediano a nivel del antebrazo"});
            datos.addRow(new Object[] {"Traumatismo del nervio radial a nivel del antebrazo"});
            datos.addRow(new Object[] {"Traumatismo del nervio sensorial cutáneo a nivel del antebrazo"});
            datos.addRow(new Object[] {"Traumatismo de múltiples nervios del antebrazo"});
            datos.addRow(new Object[] {"Traumatismo del tendón y músculo flexor del pulgar a nivel del antebrazo"});
            datos.addRow(new Object[] {"Traumatismo del tendón y músculo flexor de otros dedos a nivel del antebrazo"});
            datos.addRow(new Object[] {"Traumatismo del tendón y músculo flexor a nivel del antebrazo"});
            datos.addRow(new Object[] {"Traumatismo de tendones y músculos abductores y extensores del pulgar a nivel del antebrazo"});
            datos.addRow(new Object[] {"Traumatismo del tendón y músculo extendor de otros dedos a nivel del antebrazo"});
            datos.addRow(new Object[] {"Amputación traumática a nivel del codo"});
            datos.addRow(new Object[] {"Amputación traumática nivel entre el codo y la muñeca"});
            datos.addRow(new Object[] {"Contusión de dedos de la mano, sin daño de las uñas"});
            datos.addRow(new Object[] {"Contusión de dedos de la mano, con daño de las uñas"});
            datos.addRow(new Object[] {"Contusión de las otras partes de la muñeca y de la mano"});
            datos.addRow(new Object[] {"Herida de dedos de la mano, sin daño de las uñas"});
            datos.addRow(new Object[] {"Herida de dedos de la mano, con daño de las uñas"});
            datos.addRow(new Object[] {"Heridas múltiples de la muñeca y de la mano"});
            datos.addRow(new Object[] {"Fractura del hueso escafoides navicular de la mano"});
            datos.addRow(new Object[] {"Fractura de otros huesos del carpo"});
            datos.addRow(new Object[] {"Fractura del primer metacarpiano"});
            datos.addRow(new Object[] {"Fracturas de otros huesos del carpo"});
            datos.addRow(new Object[] {"Fracturas múltiples de huesos metacarpianos"});
            datos.addRow(new Object[] {"Fractura del pulgar"});
            datos.addRow(new Object[] {"Luxación de la muñeca"});
            datos.addRow(new Object[] {"Luxación de los dedos de la muñeca"});
     
            datos.addRow(new Object[] {"Luxaciones múltiples de dedos de la mano"});
            datos.addRow(new Object[] {"Ruptura traumática de ligamentos de la muñeca y del carpo"});
            datos.addRow(new Object[] {"Ruptura traumática de ligamentos de dedos de la mano en las articulaciónes metacarpofalángica e interfalángica"});
            datos.addRow(new Object[] {"Esguinces y torceduras de dedos de la mano"});
            datos.addRow(new Object[] {"Esguinces y torceduras de otras partes y de las no especificadas de la muñeca y de la mano"});
            datos.addRow(new Object[] {"Traumatismo del nervio cubital a nivel de la muñeca y de la mano"});
            datos.addRow(new Object[] {"Traumatismo del nervio mediano a nivel de la muñeca y de la mano"});
            datos.addRow(new Object[] {"Traumatismo del nervio radial a nivel de la muñeca y de la mano"});
            datos.addRow(new Object[] {"Traumatismo del nervio digital del pulgar"});
            datos.addRow(new Object[] {"Traumatismo del nervio digital de otro dedo"});
            datos.addRow(new Object[] {"Traumatismo del tendón y músculo flexor de otro dedo a nivel de la muñeca y de la mano"});
            datos.addRow(new Object[] {"Traumatismo del tendón y músculo extensor del pulgar a nivel de la muñeca y de la mano"});
            datos.addRow(new Object[] {"Traumatismo del tendón y músculo extensor de otros dedos a nivel de la muñeca y de la mano"});
            datos.addRow(new Object[] {"Traumatismo del músculo y tendón intrínseco del pulgar a nivel de la muñeca y de la mano"});
            datos.addRow(new Object[] {"Traumatismo del músculo y tendón intrínseco de otros dedos a nivel de la muñeca y de la mano"});
            datos.addRow(new Object[] {"Traumatismo de múltiples tendones y músculo flexores a nivel de la muñeca y de la mano"});
            datos.addRow(new Object[] {"Traumatismo de múltiples tendones y músculo extensores a nivel de la muñeca y de la mano"});
            datos.addRow(new Object[] {"Traumatismo de otros tendones y músculos a nivel de la muñeca y de la mano"});
            datos.addRow(new Object[] {"Traumatismo por aplastamiento de otras partes y de las no especificadas de la muñeca y de la mano"});
            datos.addRow(new Object[] {"Amputación traumática de la muñeca y de la mano"});
            datos.addRow(new Object[] {"Amputación traumática del pulgar completa parcial"});
            datos.addRow(new Object[] {"Amputación traumática de otro dedo único completa parcial"});
            datos.addRow(new Object[] {"Amputación traumática de dos o más dedos solamente completa parcial"});
            datos.addRow(new Object[] {"Amputación traumática de la mano nivel de la muñeca"});
            datos.addRow(new Object[] {"Contusión de la cadera"});
            datos.addRow(new Object[] {"Contusión del muslo"});
            datos.addRow(new Object[] {"Traumatismos superficiales múltiples de la cadera y del muslo"});
            datos.addRow(new Object[] {"Otros traumatismos superficiales de la cadera y del muslo"});
            datos.addRow(new Object[] {"Herida de la cadera"});
            datos.addRow(new Object[] {"Herida del muslo"});
            datos.addRow(new Object[] {"Heridas múltiples de la cadera y del muslo"});
            datos.addRow(new Object[] {"Fractura del cuello de fémur"});
            datos.addRow(new Object[] {"Fractura pertrocanteriana"});
            datos.addRow(new Object[] {"Fractura subtrocanteriana"});
            datos.addRow(new Object[] {"Fractura de la diálisis del fémur"});
            datos.addRow(new Object[] {"Fractura de la epífisis interior del fémur"});
            datos.addRow(new Object[] {"Fracturas múltiples del fémur"});
            datos.addRow(new Object[] {"Fracturas de otras partes del fémur"});
            datos.addRow(new Object[] {"Luxación de la cadera"});
            datos.addRow(new Object[] {"Esguines y torceduras de la cadera"});
            datos.addRow(new Object[] {"Traumatismo del nervio ciático a nivel de la cadera y del muslo"});
            datos.addRow(new Object[] {"Traumatismo del nervio femorocuatáneo a nivel de la cadera y del muslo"});
            datos.addRow(new Object[] {"Traumatismo de nervios múltiples a nivel de la cadera y del muslo"});
            datos.addRow(new Object[] {"Traumatismo del tendón y músculo de la cadera"});
            datos.addRow(new Object[] {"Traumatismo del tendón músculo cuádriceps"});
            datos.addRow(new Object[] {"Traumatismo del tendón y músculo aductor mayor del muslo"});
            datos.addRow(new Object[] {"Traumatismo del tendón y músculo del grupo muscular posterior a nivel del muslo"});
            datos.addRow(new Object[] {"Traumatismo de otros tendones y músculos y los no especificados a nivel del muslo"});
            datos.addRow(new Object[] {"Traumatismo de múltiples tendones y músculo a nivel de la cadera y del muslo"});
            datos.addRow(new Object[] {"Contusión de la rodilla"});
            datos.addRow(new Object[] {"Otros traumatismos superficiales de la pierna"});
            datos.addRow(new Object[] {"Herida de la rodilla"});
            datos.addRow(new Object[] {"Heridas múltiples de la pierna"});
            datos.addRow(new Object[] {"Fractura de la rótula"});
            datos.addRow(new Object[] {"Fractura de la epífisis superior de la tibia"});
            datos.addRow(new Object[] {"Fractura de la diáfisis de la tibia"});
            datos.addRow(new Object[] {"Fractura de la epífisis inferior de la tibia"});
            datos.addRow(new Object[] {"Fractura del peroné solamente"});
            datos.addRow(new Object[] {"Fractura del maléolo interno"});
            datos.addRow(new Object[] {"Fractura del maléolo externo"});
            datos.addRow(new Object[] {"Fractura múltiples de la pierna"});
            datos.addRow(new Object[] {"Luxación de la rótula"});
            datos.addRow(new Object[] {"Luxación de la rodilla"});
            datos.addRow(new Object[] {"Desgarro de meniscos"});
            datos.addRow(new Object[] {"Desgarro del cartílago articular de la rodilla"});
            datos.addRow(new Object[] {"Esguinces y torceduras que comprometen los ligamentos laterales"});
            datos.addRow(new Object[] {"Esguinces y torceduras que comprometen el ligamento cruzado"});
            datos.addRow(new Object[] {"Esguinces y torceduras de otras partes y no especificadas de la rodilla"});
            datos.addRow(new Object[] {"Traumatismo de estructuras múltiples de la rodilla"});
            datos.addRow(new Object[] {"Traumatismo del nervio tibial a nivel de la pierna"});
            datos.addRow(new Object[] {"Traumatismo del nervio peroneo a nivel de la pierna"});
            datos.addRow(new Object[] {"Traumatismo de otros nervios a nivel de la pierna"});
            datos.addRow(new Object[] {"Traumatismo del tendón de aquiles"});
            datos.addRow(new Object[] {"Traumatismo de otros tendones y músculos del grupo muscular posterior a nivel de la pierna"});
            datos.addRow(new Object[] {"Traumatismo de tendones y músculos del grupo muscular anterior a nivel de la pierna"});
            datos.addRow(new Object[] {"Traumatismo de tendones y músculos del grupo muscular peroneo a nivel de la pierna"});
            datos.addRow(new Object[] {"Traumatismo de múltiples tendones y músculos a nivel de la pierna"});
            datos.addRow(new Object[] {"Traumatismo de otros tendones y músculos a nivel de la pierna"});
            datos.addRow(new Object[] {"Traumatismo de tendón y músculo no especificado a nivel de la pierna"});
            datos.addRow(new Object[] {"Traumatismo por aplastamiento de la pierna"});
            datos.addRow(new Object[] {"Amputación traumática de la pierna"});
            datos.addRow(new Object[] {"Amputación traumática a nivel de la rodilla"});
            datos.addRow(new Object[] {"Amputación traumática en algún nivel entre la rodilla y el tobillo"});
            datos.addRow(new Object[] {"Contusión del tobillo"});
            datos.addRow(new Object[] {"Contusión de dedos del pie sin daño de las uñas"});
            datos.addRow(new Object[] {"Contusión de dedos del pie con daño de las uñas"});
            datos.addRow(new Object[] {"Contusión de otras partes y de las no especificadas del pie"});
            datos.addRow(new Object[] {"Traumatismos superficiales múltiples del pie y del tobillo"});
            datos.addRow(new Object[] {"Herida del tobillo"});
            datos.addRow(new Object[] {"Herida de dedos del pie sin daño de las uñas"});
            datos.addRow(new Object[] {"Herida de dedos del pie con daño de las uñas"});
            datos.addRow(new Object[] {"Herida de otras partes del pie"});
            datos.addRow(new Object[] {"Fractura del calcáneo"});
            datos.addRow(new Object[] {"Fractura del astrágalo"});
            datos.addRow(new Object[] {"Fractura de otros huesos del tarso"});
            datos.addRow(new Object[] {"Fractura de hueso del metatarso"});
            datos.addRow(new Object[] {"Fractura los huesos del dedo gordo del pie"});
            datos.addRow(new Object[] {"Fractura los huesos de otros huesos del pie"});
            datos.addRow(new Object[] {"Luxación de la articulación del tobillo"});
            datos.addRow(new Object[] {"Luxación de dedos del pie"});
            datos.addRow(new Object[] {"Ruptura de ligamentos a nivel del tobillo y del pie"});
            datos.addRow(new Object[] {"Luxación de otros sitios y los no especificados del pie"});
            datos.addRow(new Object[] {"Esguinces y torceduras del tobillo"});
            datos.addRow(new Object[] {"Esguinces y torceduras de dedos del pie"});
            datos.addRow(new Object[] {"Traumatismo del nervio peroneal profundo a nivel del pie y del tobillo"});
            datos.addRow(new Object[] {"Traumatismo de otros nervios a nivel del pie y del tobillo"});
            datos.addRow(new Object[] {"Traumatismo del tendón y músculo del flexor largo del dedo a nivel del pie y del tobillo"});
            datos.addRow(new Object[] {"Traumatismo del tendón y músculo del extensor largo de los dedos a nivel del pie y del tobillo"});
            datos.addRow(new Object[] {"Traumatismo de tendones y músculos intrínsecos a nivel del pie y del tobillo"});
            datos.addRow(new Object[] {"Traumatismo de múltiples tendones y músculos a nivel del pie y del tobillo"});
            datos.addRow(new Object[] {"Traumatismo de otros tendones y músculos a nivel del pie y del tobillo"});
            datos.addRow(new Object[] {"Traumatismo por aplastamiento de dedos del pie"});
            datos.addRow(new Object[] {"Traumatismo por aplastamiento de otras partes del pie y del tobillo"});
            datos.addRow(new Object[] {"Amputación traumática del pie y del tobillo"});
            datos.addRow(new Object[] {"Amputación traumática del pie a nivel del tobillo"});
            datos.addRow(new Object[] {"Amputación traumática de un dedo del pie"});
            datos.addRow(new Object[] {"Amputación traumática de dos o más dedos del pie"});
            datos.addRow(new Object[] {"Traumatismos superficiales que afectan múltiples regiones de los miembros superiores"});
            datos.addRow(new Object[] {"Traumatismos superficiales que afectan múltiples regiones de los miembros inferiores"});
            datos.addRow(new Object[] {"Traumatismos superficiales que afectan otras combinaciones de regiones del cuerpo"});
            datos.addRow(new Object[] {"Quemadura de la cabeza y del cuello, grado no especificado"});
            datos.addRow(new Object[] {"Quemadura de la cabeza y del cuello, de primer grado"});
            datos.addRow(new Object[] {"Quemadura de la cabeza y del cuello, de segundo grado"});
            datos.addRow(new Object[] {"Quemadura de la cabeza y del cuello, de tercer grado"});
            datos.addRow(new Object[] {"Quemadura del tronco, grado no especificado"});
            datos.addRow(new Object[] {"Quemadura del tronco, de primer grado"});
            datos.addRow(new Object[] {"Quemadura del tronco, de segundo grado"});
            datos.addRow(new Object[] {"Quemadura del tronco, de tercer grado"});
            datos.addRow(new Object[] {"Quemadura del hombro y miembro superior, grado no especificado, excepto de la muñeca de la mano"});
            datos.addRow(new Object[] {"Quemadura del hombro y miembro superior, primer grado, excepto de la muñeca de la mano"});
            datos.addRow(new Object[] {"Quemadura de la muñeca y de la mano, grado no especificado"});
            datos.addRow(new Object[] {"Quemadura de la muñeca y de la mano, de primer grado"});
            datos.addRow(new Object[] {"Quemadura de la muñeca y de la mano, de segundo grado"});
            datos.addRow(new Object[] {"Quemadura de la muñeca y de la mano, de tercer grado"});
            datos.addRow(new Object[] {"Quemadura de la cadera y miembro inferior, grado no especificado, excepto tobillo y pie"});
            datos.addRow(new Object[] {"Quemadura de la cadera y miembro inferior, de primer grado, excepto tobillo y pie"});
            datos.addRow(new Object[] {"Quemadura de la cadera y miembro inferior, de segundo grado, excepto tobillo y pie"});
            datos.addRow(new Object[] {"Quemadura de la cadera y miembro inferior, de tercer grado, excepto tobillo y pie"});
            datos.addRow(new Object[] {"Quemadura del tobillo y pie, grado no especificado"});
            datos.addRow(new Object[] {"Quemadura del tobillo y pie, de primer grado"});
            datos.addRow(new Object[] {"Quemadura del tobillo y pie, de segundo grado"});
            datos.addRow(new Object[] {"Quemadura del tobillo y pie, de tercer grado"});
            datos.addRow(new Object[] {"Embolia gaseosa"});
            datos.addRow(new Object[] {"Embolia grasa"});
            datos.addRow(new Object[] {"Hemorragia traumática secundaria y recurrente"});
            datos.addRow(new Object[] {"Infección postraumática de herida, no clasificada en otra parte"});
            datos.addRow(new Object[] {"Hemorragia y hematoma que complican un procedimiento, no clasificados en otra parte"});
            datos.addRow(new Object[] {"Desgarro de herida operatoria, no clasificado en otra parte"});
            datos.addRow(new Object[] {"Complicación mecánica de prótesis articular interna"});
            datos.addRow(new Object[] {"Complicación mecánica de dispositivo de fijación interna de huesos de un miembro"});
            datos.addRow(new Object[] {"Complicación mecánica de dispositivo de fijación interna de otros huesos"});
            datos.addRow(new Object[] {"Complicación mecánica de otros dispositivos óseos, implantes e injertos"});
            datos.addRow(new Object[] {"Complicación mecánica de otros dispositivos protésicos, implantes e injertos ortopédicos internos"});
            datos.addRow(new Object[] {"Infección y reacción inflamatoria debidas a prótesis articular interna"});
            datos.addRow(new Object[] {"Infección y reacción inflamatoria debidas a dispositivo de fijación interna"});
            datos.addRow(new Object[] {"Infección y reacción inflamatoria debidas a otros dispositivos protésicos, implantes e injertos ortopédicos internos"});
            datos.addRow(new Object[] {"Otras complicaciones de dispositivos protésicos, implantes e injertos ortopédicos internos"});
            datos.addRow(new Object[] {"Neuroma de muñón de amputación"});
            datos.addRow(new Object[] {"Infección de muñón de amputación"});
            datos.addRow(new Object[] {"Necrosis de muñón de amputación"});
            datos.addRow(new Object[] {"Otras complicaciones y las no especificadas de muñón de amputación"});
            datos.addRow(new Object[] {"Secuelas de fractura del cráneo y de huesos faciales"});
            datos.addRow(new Object[] {"Secuelas de fractura de la columna vertebral"});
            datos.addRow(new Object[] {"Secuelas de traumatismo de la médula espinal"});
            datos.addRow(new Object[] {"Secuelas de herida de miembro superior"});
            datos.addRow(new Object[] {"Secuelas de fractura del brazo"});
            datos.addRow(new Object[] {"Secuelas de fractura de la muñeca y de la mano"});
            datos.addRow(new Object[] {"Secuelas de luxación, torcedura y esguince de miembro superior"});
            datos.addRow(new Object[] {"Secuelas de traumatismo de nervio y de miembro superior"});
            datos.addRow(new Object[] {"Secuelas de traumatismo de tendón y músculo de miembro superior"});
            datos.addRow(new Object[] {"Secuelas de herida de miembro inferior"});
            datos.addRow(new Object[] {"Secuelas de fractura del fémur"});
            datos.addRow(new Object[] {"Secuelas de otras fracturas de miembro inferior"});
            datos.addRow(new Object[] {"Secuelas de luxación, torcedura y esguince de miembro inferior"});
            datos.addRow(new Object[] {"Secuelas de traumatismo de nervio de miembro inferior"});
            datos.addRow(new Object[] {"Secuelas de traumatismo de tendón y músculo de miembro inferior"});
            datos.addRow(new Object[] {"Secuelas de aplastamiento y amputación traumáticas de miembro inferior"});
            datos.addRow(new Object[] {"Secuelas de otros traumatismos especificados de miembro inferior"});
            datos.addRow(new Object[] {"Secuelas de traumatismos que afectan múltiples regiones del cuerpo"});
        
        
        tblDiagnostico.setModel(datos);
        
        
        
        }
      
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtTraInd = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtNomPac = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        txtDiaRep = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtExamenes = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtExaFis = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtMotCon = new javax.swing.JTextArea();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblDiagnostico = new javax.swing.JTable();
        busca = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        lblImagen = new javax.swing.JLabel();
        lblImagenPrevia = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        receta = new javax.swing.JTextArea();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        indicaciones = new javax.swing.JTextArea();
        txtNumCed = new javax.swing.JTextField();
        btnCedula = new javax.swing.JButton();
        txtEstCiv = new javax.swing.JTextField();
        txtOcu = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        txtEdad = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtSexPac = new javax.swing.JTextField();
        txtRes = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblFecha = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtTraInd.setColumns(20);
        txtTraInd.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtTraInd.setRows(5);
        jScrollPane1.setViewportView(txtTraInd);

        jLabel11.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel11.setText("Tratamiento e indicaciones: ");

        jLabel8.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel8.setText("Examenes:");

        jLabel9.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel9.setText("Examen Físico:");

        jLabel12.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel12.setText("Motivo de consulta: ");

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jLabel1.setText("Consulta ");

        jLabel14.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel14.setText("Telefono Paciente: ");

        jLabel15.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel15.setText("Nombre del Paciente: ");

        txtNomPac.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtNomPac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomPacActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel16.setText("Edad:");

        jLabel17.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel17.setText("Número de cédula:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/baseline_search_black_18dp_1.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButton2.setText("Generar Resumen Historia Clinica");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel19.setText("Días de reposo:");

        txtDiaRep.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtDiaRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaRepActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButton3.setText("Generar Certificado Médico");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtExamenes.setColumns(20);
        txtExamenes.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtExamenes.setRows(5);
        jScrollPane3.setViewportView(txtExamenes);

        txtExaFis.setColumns(20);
        txtExaFis.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtExaFis.setRows(5);
        jScrollPane4.setViewportView(txtExaFis);

        txtMotCon.setColumns(20);
        txtMotCon.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtMotCon.setRows(5);
        jScrollPane5.setViewportView(txtMotCon);

        jButton5.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButton5.setText("Generar Consulta");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel2.setText("max:40");

        jLabel10.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel10.setText("Diagnóstico:");

        tblDiagnostico.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblDiagnostico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CIE10"
            }
        ));
        jScrollPane7.setViewportView(tblDiagnostico);

        busca.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        busca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscaKeyReleased(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButton6.setText("Elegir Imagen");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel18.setText("Receta:");

        receta.setColumns(20);
        receta.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        receta.setRows(5);
        jScrollPane2.setViewportView(receta);

        jLabel20.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel20.setText("Indicaciones de la receta:");

        indicaciones.setColumns(20);
        indicaciones.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        indicaciones.setRows(5);
        jScrollPane6.setViewportView(indicaciones);

        txtNumCed.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        btnCedula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/baseline_search_black_18dp_1.png"))); // NOI18N
        btnCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCedulaActionPerformed(evt);
            }
        });

        txtEstCiv.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        txtOcu.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtOcu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOcuActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButton7.setText("Ingresar Paciente");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        txtEdad.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdadActionPerformed(evt);
            }
        });

        txtTelefono.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });

        txtSexPac.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        txtRes.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel21.setText("Sexo del Paciente: ");

        jLabel22.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel22.setText("Residencia:");

        jLabel25.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel25.setText("Ocupación:");

        jLabel26.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel26.setText("Estado Civil:");

        tblFecha.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tblFecha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblFecha.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblFecha.setRowHeight(20);
        tblFecha.setRowMargin(3);
        jScrollPane9.setViewportView(tblFecha);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Traumatologia.PNG"))); // NOI18N

        jButton4.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButton4.setText("Nuevo");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane6)
                            .addComponent(jScrollPane4)
                            .addComponent(jScrollPane3)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel18)
                                            .addComponent(jLabel20)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel19)
                                                .addGap(69, 69, 69)
                                                .addComponent(txtDiaRep, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(34, 34, 34)
                                                .addComponent(jLabel2))
                                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(busca, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(119, 119, 119)
                                        .addComponent(jButton4)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(67, 67, 67))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addGap(330, 330, 330))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel25))
                                .addGap(275, 275, 275))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblImagenPrevia, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(47, 47, 47))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNomPac, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel16)
                                .addComponent(jLabel21))
                            .addGap(53, 53, 53)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtEdad)
                                .addComponent(txtSexPac, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel17)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNumCed, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtEstCiv, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtOcu, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRes, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(55, 55, 55)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jLabel3)))
                .addGap(73, 73, 73))
            .addGroup(layout.createSequentialGroup()
                .addGap(749, 749, 749)
                .addComponent(jLabel1)
                .addGap(108, 108, 108))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNumCed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel17)))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(txtNomPac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtEdad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel21)
                                    .addComponent(txtSexPac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(txtRes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(95, 95, 95)
                                        .addComponent(txtEstCiv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtOcu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(149, 149, 149)
                                .addComponent(jLabel22)
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(99, 99, 99)
                                        .addComponent(jLabel26))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel25)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(418, 418, 418)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton6)
                                            .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblImagenPrevia, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(711, 711, 711)
                                        .addComponent(jButton7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton5)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton2)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton3))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel3))
                                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 869, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(busca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton4)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel19)
                                    .addComponent(txtDiaRep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)))
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 878, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(45, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try
        {
              MainController entra = new MainController();
            String id = entra.IdConsulta(txtNumCed.getText()); 
            
            
            
            
            
        //Creación del Reporte
            Map <String, Object> mapa = new HashMap<String,Object>();
            mapa.put("nombrePaciente", "%"+txtNomPac.getText()+"%");
            mapa.put("cedulaPaciente", "%"+txtNumCed.getText()+"%");
            mapa.put("rxImg", lblImagen.getText());
            System.out.println(lblImagen.getText());
             
            MainController conexion = new MainController();
            JasperReport reporte = JasperCompileManager.compileReport("resumenHistoriaClinicaHorizontal.jrxml");
            JasperPrint jprint = JasperFillManager.fillReport(reporte, mapa, conexion.conexion());
            JasperExportManager.exportReportToPdfFile(jprint,"resumenHistoriaClinica"+id+".pdf");
            JOptionPane.showMessageDialog(this,"Historia clínica generada con éxito");
            //Abir
            Process p = Runtime.getRuntime().exec ("rundll32 SHELL32.DLL,ShellExec_RunDLL "+"D:\\TraumatologiaDrGalarza\\dist\\resumenHistoriaClinica"+id+".pdf");
            
        } catch (JRException ex) {
            
        } catch (IOException ex) {
            Logger.getLogger(IngresoConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
     
        Date fechaActual = new Date();
        Calendar previousDate = Calendar.getInstance();
        previousDate.setTime(fechaActual);
        Date stringPreviousDate = previousDate.getTime();
        SimpleDateFormat formato2 = new SimpleDateFormat("dd-MM-yyyy");
        String previousDateOne = null;
        previousDateOne = formato2.format(stringPreviousDate);
        String dia2=null;
        String mes2 = null;
        String anio2 = null;
        
       
        //Días
        System.out.println(previousDateOne.substring(0,2));
        if(previousDateOne.substring(0,2).contains("1")){
            dia2 = "Uno";
        }
        if(previousDateOne.substring(0,2).contains("2")){
            dia2 = "Dos";
        }
        if(previousDateOne.substring(0,2).contains("3")){
            dia2 = "Tres";
        }
        if(previousDateOne.substring(0,2).contains("4")){
            dia2 = "Cuatro";
        }
        if(previousDateOne.substring(0,2).contains("5")){
            dia2 = "Cinco";
        }
        if(previousDateOne.substring(0,2).contains("6")){
            dia2 = "Seis";
        }
        if(previousDateOne.substring(0,2).contains("7")){
            dia2 = "Siete";
        }
        if(previousDateOne.substring(0,2).contains("8")){
            dia2 = "Ocho";
        }
        if(previousDateOne.substring(0,2).contains("9")){
            dia2 = "Nueve";
        }
        if(previousDateOne.substring(0,2).contains("10")){
            dia2 = "Diez";
        }
        if(previousDateOne.substring(0,2).contains("11")){
            dia2 = "Once";
        }
        if(previousDateOne.substring(0,2).contains("12")){
            dia2 = "Doce";
        }
        if(previousDateOne.substring(0,2).contains("13")){
            dia2 = "Trece";
        }
        if(previousDateOne.substring(0,2).contains("14")){
            dia2 = "Catorce";
        }
        if(previousDateOne.substring(0,2).contains("15")){
            dia2 = "Quince";
        }
        if(previousDateOne.substring(0,2).contains("16")){
            dia2 = "Diez y seis";
        }
        if(previousDateOne.substring(0,2).contains("17")){
            dia2 = "Diez y siete";
        }
        if(previousDateOne.substring(0,2).contains("18")){
            dia2 = "Diez y ocho";
        }
        if(previousDateOne.substring(0,2).contains("19")){
            dia2 = "Diez y nueve";
        }
        if(previousDateOne.substring(0,2).contains("20")){
            dia2 = "Veinte";
        }
        if(previousDateOne.substring(0,2).contains("21")){
            dia2 = "Veinte y uno";
        }
        if(previousDateOne.substring(0,2).contains("22")){
            dia2 = "Veinte y dos";
        }
        if(previousDateOne.substring(0,2).contains("23")){
            dia2 = "Veinte y tres";
        }
        if(previousDateOne.substring(0,2).contains("24")){
            dia2 = "Veinte y cuatro";
        }
        if(previousDateOne.substring(0,2).contains("25")){
            dia2 = "Veinte y cinco";
        }
        if(previousDateOne.substring(0,2).contains("26")){
            dia2 = "Veinte y seis";
        }
        if(previousDateOne.substring(0,2).contains("27")){
            dia2 = "Veinte y siete";
        }
        if(previousDateOne.substring(0,2).contains("28")){
            dia2 = "Veinte y ocho";
        }
        if(previousDateOne.substring(0,2).contains("29")){
            dia2 = "Veinte y nueve";
        }
        if(previousDateOne.substring(0,2).contains("30")){
            dia2 = "Treinta";
        }
        if(previousDateOne.substring(0,2).contains("31")){
            dia2 = "Treinta y uno";
        }
        
        //OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
        //Mes2es
        if(previousDateOne.substring(3,5).contains("1")){
        mes2 = "Enero";
        }
        if(previousDateOne.substring(3,5).contains("2")){
        mes2 = "Febrero";
        }
        if(previousDateOne.substring(3,5).contains("3")){
        mes2 = "Marzo";
        }
        if(previousDateOne.substring(3,5).contains("4")){
        mes2 = "Abril";
        }
        if(previousDateOne.substring(3,5).contains("5")){
        mes2 = "Mayo";
        }
        if(previousDateOne.substring(3,5).contains("6")){
        mes2 = "Junio";
        }
        if(previousDateOne.substring(3,5).contains("7")){
        mes2 = "Julio";
        }
        if(previousDateOne.substring(3,5).contains("8")){
        mes2 = "Agosto";
        }
        if(previousDateOne.substring(3,5).contains("9")){
        mes2 = "Septiembre";
        }
        if(previousDateOne.substring(3,5).contains("10")){
        mes2 = "Octubre";
        }
        if(previousDateOne.substring(3,5).contains("11")){
        mes2 = "Noviembre";
        }
        if(previousDateOne.substring(3,5).contains("12")){
        mes2 = "Diciembre";
        }
        
        //Años
        System.out.println(previousDateOne.substring(6,10));
        if(previousDateOne.substring(6,10).contains("2020")){
            anio2 = "dos mil veinte";
        }
        if(previousDateOne.substring(6,10).contains("2021")){
            anio2 = "dos mil veintiuno";
        }
        String nuevoPrevio = dia2+" de "+ mes2.toLowerCase()+" de "+anio2.toLowerCase();
        
        System.out.println(nuevoPrevio);
        
          //OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
        //Nuevo anio letras
        // Fecha a ser sumada
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaActual); // Configuramos la fecha que se recibe
        calendar.add(Calendar.DAY_OF_YEAR, Integer.valueOf(txtDiaRep.getText()));  // numero de días a añadir, o restar en caso de días<0
        Date stringNuevo = calendar.getTime();
        SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");  
        String inActiveDate = null;
        inActiveDate = format1.format(stringNuevo); 
        System.out.println(inActiveDate);
      
        //Formateo de letras del anio
        String dia = null;
        String mes = null;
        String anio = null;
        
        //Días
        System.out.println(inActiveDate.substring(0,2));
        if(inActiveDate.substring(0,2).contains("1")){
            dia = "Uno";
        }
        if(inActiveDate.substring(0,2).contains("2")){
            dia = "Dos";
        }
        if(inActiveDate.substring(0,2).contains("3")){
            dia = "Tres";
        }
        if(inActiveDate.substring(0,2).contains("4")){
            dia = "Cuatro";
        }
        if(inActiveDate.substring(0,2).contains("5")){
            dia = "Cinco";
        }
        if(inActiveDate.substring(0,2).contains("6")){
            dia = "Seis";
        }
        if(inActiveDate.substring(0,2).contains("7")){
            dia = "Siete";
        }
        if(inActiveDate.substring(0,2).contains("8")){
            dia = "Ocho";
        }
        if(inActiveDate.substring(0,2).contains("9")){
            dia = "Nueve";
        }
        if(inActiveDate.substring(0,2).contains("10")){
            dia = "Diez";
        }
        if(inActiveDate.substring(0,2).contains("11")){
            dia = "Once";
        }
        if(inActiveDate.substring(0,2).contains("12")){
            dia = "Doce";
        }
        if(inActiveDate.substring(0,2).contains("13")){
            dia = "Trece";
        }
        if(inActiveDate.substring(0,2).contains("14")){
            dia = "Catorce";
        }
        if(inActiveDate.substring(0,2).contains("15")){
            dia = "Quince";
        }
        if(inActiveDate.substring(0,2).contains("16")){
            dia = "Diez y seis";
        }
        if(inActiveDate.substring(0,2).contains("17")){
            dia = "Diez y siete";
        }
        if(inActiveDate.substring(0,2).contains("18")){
            dia = "Diez y ocho";
        }
        if(inActiveDate.substring(0,2).contains("19")){
            dia = "Diez y nueve";
        }
        if(inActiveDate.substring(0,2).contains("20")){
            dia = "Veinte";
        }
        if(inActiveDate.substring(0,2).contains("21")){
            dia = "Veinte y uno";
        }
        if(inActiveDate.substring(0,2).contains("22")){
            dia = "Veinte y dos";
        }
        if(inActiveDate.substring(0,2).contains("23")){
            dia = "Veinte y tres";
        }
        if(inActiveDate.substring(0,2).contains("24")){
            dia = "Veinte y cuatro";
        }
        if(inActiveDate.substring(0,2).contains("25")){
            dia = "Veinte y cinco";
        }
        if(inActiveDate.substring(0,2).contains("26")){
            dia = "Veinte y seis";
        }
        if(inActiveDate.substring(0,2).contains("27")){
            dia = "Veinte y siete";
        }
        if(inActiveDate.substring(0,2).contains("28")){
            dia = "Veinte y ocho";
        }
        if(inActiveDate.substring(0,2).contains("29")){
            dia = "Veinte y nueve";
        }
        if(inActiveDate.substring(0,2).contains("30")){
            dia = "Treinta";
        }
        if(inActiveDate.substring(0,2).contains("31")){
            dia = "Treinta y uno";
        }
        
        //OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
        //Meses
        if(inActiveDate.substring(3,5).contains("1")){
        mes = "Enero";
        }
        if(inActiveDate.substring(3,5).contains("2")){
        mes = "Febrero";
        }
        if(inActiveDate.substring(3,5).contains("3")){
        mes = "Marzo";
        }
        if(inActiveDate.substring(3,5).contains("4")){
        mes = "Abril";
        }
        if(inActiveDate.substring(3,5).contains("5")){
        mes = "Mayo";
        }
        if(inActiveDate.substring(3,5).contains("6")){
        mes = "Junio";
        }
        if(inActiveDate.substring(3,5).contains("7")){
        mes = "Julio";
        }
        if(inActiveDate.substring(3,5).contains("8")){
        mes = "Agosto";
        }
        if(inActiveDate.substring(3,5).contains("9")){
        mes = "Septiembre";
        }
        if(inActiveDate.substring(3,5).contains("10")){
        mes = "Octubre";
        }
        if(inActiveDate.substring(3,5).contains("11")){
        mes = "Noviembre";
        }
        if(inActiveDate.substring(3,5).contains("12")){
        mes = "Diciembre";
        }
        
        //Años
        System.out.println(inActiveDate.substring(6,10));
        if(inActiveDate.substring(6,10).contains("2020")){
            anio = "dos mil veinte";
        }
        if(inActiveDate.substring(6,10).contains("2021")){
            anio = "dos mil veinte y uno";
        }
        String nuevo = dia+" de "+ mes.toLowerCase()+" de "+anio.toLowerCase();
        try
        {
            MainController entra = new MainController();
            String id = entra.IdConsulta(txtNumCed.getText()); 
            
            
            //Creación del Reporte
            Map <String, Object> mapa = new HashMap<String,Object>();
            mapa.put("nombrePaciente", "%"+txtNomPac.getText()+"%");
            mapa.put("cedulaPaciente", "%"+txtNumCed.getText()+"%");
            mapa.put("fechaFinReposo", inActiveDate);
            mapa.put("fechaFinReposoTexto", nuevo);
            mapa.put("fechaInicioReposo", nuevoPrevio);
            MainController conexion = new MainController();
            JasperReport reporte = JasperCompileManager.compileReport("certificadoMedico.jrxml");
            JasperPrint jprint = JasperFillManager.fillReport(reporte, mapa, conexion.conexion());
            JasperExportManager.exportReportToPdfFile(jprint,"certificadoMedico"+id+".pdf");
            JOptionPane.showMessageDialog(this,"Certificado médico generado con éxito");
            
            //Abir
            Process p = Runtime.getRuntime().exec ("rundll32 SHELL32.DLL,ShellExec_RunDLL "+"D:\\TraumatologiaDrGalarza\\dist\\certificadoMedico"+id+".pdf");
            
            
            
        } catch (JRException ex) {
            
            System.out.println(ex);
        } catch (IOException ex) {
            Logger.getLogger(IngresoConsulta.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          
            
            if(!txtEdad.getText().isEmpty()){
                txtNomPac.setText("");
                txtTelefono.setText("");
                txtEdad.setText("");
                txtNumCed.setText("");
                txtSexPac.setText("");
                txtRes.setText("");
                txtEstCiv.setText("");
                txtOcu.setText("");
                txtTelefono.setText("");
            }
            
            try
            {
                MainController entra = new MainController();
                
            datosPaciente = entra.consultaDatosPaciente(txtNomPac.getText());
            txtNomPac.setText((String) datosPaciente.get(0));
            txtTelefono.setText((String)datosPaciente.get(1));
            txtEdad.setText((String)datosPaciente.get(2));
            txtNumCed.setText((String)datosPaciente.get(3));
            txtSexPac.setText((String) datosPaciente.get(4));
            txtRes.setText((String) datosPaciente.get(5));
            txtEstCiv.setText((String) datosPaciente.get(6));
            txtOcu.setText((String) datosPaciente.get(7));
            txtTelefono.setText((String) datosPaciente.get(8));
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Ingrese paciente por favor");
            }
            
            
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtNomPacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomPacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomPacActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
             proximaConsulta = JOptionPane.showInputDialog(this,"Ingrese la fecha de la próxima consulta (dd/mm/yyyy)");
          
            String cie10 = null;
            int x = this.tblDiagnostico.getSelectedRow();
            int y = this.tblDiagnostico.getSelectedColumn();
            
           
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Coxartrosis unilateral"))
            {
                cie10="M16.1";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Coxartrosis bilateral"))
            {
                cie10="M16.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Gonortrosis unilateral"))
            {
                cie10="M17.1";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Gonortrosis bilateral"))
            {
                cie10="M17.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Deformación congénita de la cadera")||this.tblDiagnostico.getValueAt(x,y).toString().equals("deformación congenita de la cadera"))
            {
                cie10="Q65.8";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Espina bífida")||this.tblDiagnostico.getValueAt(x,y).toString().equals("espina bifida"))
            {
                cie10="Q05.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Espina bífida oculta")||this.tblDiagnostico.getValueAt(x,y).toString().equals("espina bifida oculto"))
            {
                cie10="Q76.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Luxación congénita de cadera unilateral")||this.tblDiagnostico.getValueAt(x,y).toString().equals("luxacion congenita de cadera unilateral")||this.tblDiagnostico.getValueAt(x,y).toString().equals("luxación congenita de cadera unilateral")||this.tblDiagnostico.getValueAt(x,y).toString().equals("luxacion congénita de cadera unilateral"))
            {
                cie10="Q65.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Luxación congénita de cadera bilateral")||this.tblDiagnostico.getValueAt(x,y).toString().equals("luxacion congenita de cadera bilateral")||this.tblDiagnostico.getValueAt(x,y).toString().equals("luxación congenita de cadera bilateral")||this.tblDiagnostico.getValueAt(x,y).toString().equals("luxacion congénita de cadera bilateral"))
            {
                cie10="Q65.1";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Subluxación congénita de cadera unilateral")||this.tblDiagnostico.getValueAt(x,y).toString().equals("subluxacion congenita de cadera unilateral")||this.tblDiagnostico.getValueAt(x,y).toString().equals("subluxación congenita de cadera unilateral")||this.tblDiagnostico.getValueAt(x,y).toString().equals("subluxacion congénita de cadera unilateral"))
            {
                cie10="Q65.3";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Subluxación congénita de cadera bilateral")||this.tblDiagnostico.getValueAt(x,y).toString().equals("subluxacion congenita de cadera bilateral")||this.tblDiagnostico.getValueAt(x,y).toString().equals("subluxación congenita de cadera bilateral")||this.tblDiagnostico.getValueAt(x,y).toString().equals("subluxacion congénita de cadera bilateral"))
            {
                cie10="Q65.4";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Cadera inestable"))
            {
                cie10="Q65.6";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Deformidades congenitas de los pies")||this.tblDiagnostico.getValueAt(x,y).toString().equals("deformidades congénitas de los pies"))
            {
                cie10="Q66.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Pie plano congenito")||this.tblDiagnostico.getValueAt(x,y).toString().equals("pie plano congénito"))
            {
                cie10="Q66.5";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Pie cavus")||this.tblDiagnostico.getValueAt(x,y).toString().equals("pie cavo"))
            {
                cie10="Q66.7";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Polidactilea")||this.tblDiagnostico.getValueAt(x,y).toString().equals("polidactilea"))
            {
                cie10="Q69.9";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Sindactilea")||this.tblDiagnostico.getValueAt(x,y).toString().equals("sindactileo"))
            {
                cie10="Q70.9";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Tumor maligno de huesos y cartílagos articulares de meniscos")||this.tblDiagnostico.getValueAt(x,y).toString().equals("tumor maligno de huesos y cartilagos articulares de meniscos"))
            {
                cie10="C40.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Tumor benigno de hueso y cartílago")||this.tblDiagnostico.getValueAt(x,y).toString().equals("tumor benigno de hueso y cartilago"))
            {
                cie10="D16.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Tumor benigno lipomatoso")||this.tblDiagnostico.getValueAt(x,y).toString().equals("tumores benignos limpomatosos"))
            {
                cie10="D17.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Hemangioma y lifangioma de cualquier sitio")||this.tblDiagnostico.getValueAt(x,y).toString().equals("hemangiomas y linfagiomas en cualquier sitio"))
            {
                cie10="D18.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Diabetes mellitus insulinodependientes"))
            {
                cie10="E10.6";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Diabetes mellitus no insulinodependientes"))
            {
                cie10="E11.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Sindrome de cushing")||this.tblDiagnostico.getValueAt(x,y).toString().equals("síndrome de cushing"))
            {
                cie10="E24.2";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Obesidad"))
            {
                cie10="E66.9";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Epilepsia"))
            {
                cie10="G40.9";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Hemiplejia"))
            {
                cie10="G40.9";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Paraplejia y cuadriplejia"))
            {
                cie10="G82.2";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Hipertensión esencial"))
            {
                cie10="I10.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Hipertensión secundaria"))
            {
                cie10="I15.9";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Varices"))
            {
                cie10="I83.9";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Absceso cutaneo"))
            {
                cie10="L02.9";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Celulitis"))
            {
                cie10="L03.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Varices"))
            {
                cie10="I83.9";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Artritis piogena"))
            {
                cie10="M00.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Artritis reumatoide seropositiva"))
            {
                cie10="M00.0";
            }            
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Gota"))
            {
                cie10="M10.9";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Poliartrosis"))
            {
                cie10="M15.3";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Otras artrosis"))
            {
                cie10="M19.1";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Cifosis y lordosis"))
            {
                cie10="M40.2";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Escoliosis"))
            {
                cie10="Q67.5";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Espondilitis anquilosante"))
            {
                cie10="M45.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Espondilosis"))
            {
                cie10="M47.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Trastornos de disco cervical"))
            {
                cie10="M50.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Dorsalgia")||this.tblDiagnostico.getValueAt(x,y).toString().equals("lumbociática aguda")||this.tblDiagnostico.getValueAt(x,y).toString().equals("lumbociatica aguda"))
            {
                cie10="M54.3";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Miositis"))
            {
                cie10="M60.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Sinovitis y tenosinovitis")||this.tblDiagnostico.getValueAt(x,y).toString().equals("sinovitis")||this.tblDiagnostico.getValueAt(x,y).toString().equals("tenosinovitis"))
            {
                cie10="M65.8";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Ruptura espontánea de la sinovial y del tendón")||this.tblDiagnostico.getValueAt(x,y).toString().equals("ruptura espontanea de la sinovial y del tendon")||this.tblDiagnostico.getValueAt(x,y).toString().equals("ruptura espontánea de la sinovial y del tendon")||this.tblDiagnostico.getValueAt(x,y).toString().equals("ruptura espontanea de la sinovial y del tendón"))
            {
                cie10="M65.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Otras bursoramas"))
            {
                cie10="M71.1";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Osteoporosis con fractura patologica")||this.tblDiagnostico.getValueAt(x,y).toString().equals("osteoporosis con fractura patológica"))
            {
                cie10="M80.9";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Osteoporosis sin fractura"))
            {
                cie10="M81.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Osteomielitis")||this.tblDiagnostico.getValueAt(x,y).toString().equals("osteomielítis"))
            {
                cie10="M86.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Osteonecrosis"))
            {
                cie10="M87.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Enfermedad de paget de los huesos")||this.tblDiagnostico.getValueAt(x,y).toString().equals("enfermedad de pagel de los huesos"))
            {
                cie10="M88.9";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Malformaciones congénitas de la columna vertebral y tórax óseo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("malformaciones congenitas de la columna vertebral y tórax óseo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("malformaciones congenitas de la columna vertebral y torax óseo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("malformaciones congenitas de la columna vertebral y torax oseo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("malformaciones congénitas de la columna vertebral y torax oseo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("malformaciones congenitas de la columna vertebral y tórax oseo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("malformaciones congenitas de la columna vertebral y tórax óseo"))
            {
                cie10="Q76.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Gangrena"))
            {
                cie10="R02.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Anormalidades de la marcha y de la movilidad"))
            {
                cie10="R26.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Cefalea"))
            {
                cie10="R51.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Convulsiones"))
            {
                cie10="R56.9";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Hemorragia"))
            {
                cie10="R58.9";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Edema"))
            {
                cie10="R60.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fiebre reumática")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fiebre reumatica")||this.tblDiagnostico.getValueAt(x,y).toString().equals("corea"))
            {
                cie10="I02.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Flebitis tromfeblitis"))
            {
                cie10="I80";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Tumefacción")||this.tblDiagnostico.getValueAt(x,y).toString().equals("tumefaccion"))
            {
                cie10="R22";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Esguince de tobillo"))
            {
                cie10="S93.4";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Tórax en quilla")||this.tblDiagnostico.getValueAt(x,y).toString().equals("torax en quilla"))
            {
                cie10="Q67";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Síndrome de túnel carpiano")||this.tblDiagnostico.getValueAt(x,y).toString().equals("sindrome de tunel carpiano"))
            {
                cie10="G56.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fascitis plantar"))
            {
                cie10="M72.2";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Espondiloartrosis"))
            {
                cie10="M450";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Hematoma"))
            {
                cie10="T14";
            }
            //Folleto
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo superficial de la nariz"))
            {
                cie10="S00.3";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismos superficiales multiples de la cabeza")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo superficiales múltiples de la cabeza"))
            {
                cie10="S00.3";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Herida del cuero cabelludo"))
            {
                cie10="S01.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Herida del párpado y de la región periocular")||this.tblDiagnostico.getValueAt(x,y).toString().equals("herida del parpado y de la region periocular"))
            {
                cie10="S01.1";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Herida de la nariz"))
            {
                cie10="S01.2";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Herida del oido")||this.tblDiagnostico.getValueAt(x,y).toString().equals("herida del oído"))
            {
                cie10="S01.3";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Heridas multiples de la cabeza")||this.tblDiagnostico.getValueAt(x,y).toString().equals("heridas múltiples de la cabeza"))
            {
                cie10="S01.7";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura de los huesos de la nariz"))
            {
                cie10="S02.2";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura de otros huesos del cráneo y de la cara")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura de otros huesos del craneo y de la car"))
            {
                cie10="S02.8";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo cerebral difuso"))
            {
                cie10="S06.2";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Otros traumatismos intracraneales"))
            {
                cie10="S06.8";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Otros traumatismos superficiales y los no especificados de la garganta"))
            {
                cie10="S10.1";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Luxación, esguince y torcedura de articulaciones y ligamentos del cuello")||this.tblDiagnostico.getValueAt(x,y).toString().equals("luxacion, esguince y torcedura de articulaciones y ligamentos del cuello"))
            {
                cie10="S13";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Luxación de vértebra cervical")||this.tblDiagnostico.getValueAt(x,y).toString().equals("luxacion de vertebra cervical"))
            {
                cie10="S13.1";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Esguinces y torceduras de la columna cervical"))
            {
                cie10="S13.4";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Herida de la parte anterior del torax")||this.tblDiagnostico.getValueAt(x,y).toString().equals("herida de la parte anterior del tórax"))
            {
                cie10="S21.1";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Herida de la parte posterior del torax")||this.tblDiagnostico.getValueAt(x,y).toString().equals("herida de la parte posterior del tórax"))
            {
                cie10="S21.2";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura de vértebra torácica")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura de vértebra toracica")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura de vertebra torácica")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura de vertebra toracica"))
            {
                cie10="S22.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fracturas múltiples de columna torácica")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fracturas multiples de columna torácica")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fracturas múltiples de columna toracica")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fracturas multiples de columna toracica"))
            {
                cie10="S22.1";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fracturas del esternón")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fracturas del esternon"))
            {
                cie10="S22.2";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura de costilla"))
            {
                cie10="S22.3";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fracturas múltiples de costillas")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fracturas multiples de costillas"))
            {
                cie10="S22.4";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura de otras partes del tórax óseo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura de otras partes del torax óseo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura de otras partes del tórax oseo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura de otras partes del torax oseo"))
            {
                cie10="S22.8";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura del tórax óseo parte no especificada")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura del torax óseo parte no especificada")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura del tórax oseo parte no especificada")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura del torax oseo parte no especificada"))
            {
                cie10="S22.9";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Luxación, esguince y torcedura de articulaciones y ligamentos del tórax")||this.tblDiagnostico.getValueAt(x,y).toString().equals("luxacion, esguince y torcedura de articulaciones y ligamentos del tórax")||this.tblDiagnostico.getValueAt(x,y).toString().equals("luxación, esguince y torcedura de articulaciones y ligamentos del torax")||this.tblDiagnostico.getValueAt(x,y).toString().equals("luxacion, esguince y torcedura de articulaciones y ligamentos del torax"))
            {
                cie10="S23";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Ruptura traumática de disco intervertebral torácico")||this.tblDiagnostico.getValueAt(x,y).toString().equals("ruptura traumatica de disco intervertebral torácico")||this.tblDiagnostico.getValueAt(x,y).toString().equals("ruptura traumática de disco intervertebral toracico")||this.tblDiagnostico.getValueAt(x,y).toString().equals("ruptura traumatica de disco intervertebral toracico"))
            {
                cie10="S23.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Luxación de vértebra torácica")||this.tblDiagnostico.getValueAt(x,y).toString().equals("luxación de vertebra toracica")||this.tblDiagnostico.getValueAt(x,y).toString().equals("luxación de vertebra torácica")||this.tblDiagnostico.getValueAt(x,y).toString().equals("luxacion de vertebra toracica"))
            {
                cie10="S23.1";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Esguinces y torceduras de columa torácica")||this.tblDiagnostico.getValueAt(x,y).toString().equals("esguinces y torceduras de columa toracica"))
            {
                cie10="S23.3";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Esguinces y torceduras de costilla y esternón")||this.tblDiagnostico.getValueAt(x,y).toString().equals("esguinces y torceduras de costilla y esternon"))
            {
                cie10="S23.4";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo de nervios periféricos del tórax")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo de nervios perifericos del tórax")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo de nervios periféricos del torax")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo de nervios perifericos del torax"))
            {
                cie10="S24.3";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo de nervios simpáticos torácicos")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo de nervios simpaticos torácicos")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo de nervios simpáticos toracicos")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo de nervios simpaticos toracicos"))
            {
                cie10="S24.4";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo de otros nervios del tórax")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo de otros nervios del torax"))
            {
                cie10="S24.5";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo de nervio no especificado del tórax")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo de nervio no especificado del torax"))
            {
                cie10="S24.6";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Aplastamiento del tórax")||this.tblDiagnostico.getValueAt(x,y).toString().equals("aplastamiento del torax"))
            {
                cie10="S28.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Contusión de la región lumbosacra y de la pelvis")||this.tblDiagnostico.getValueAt(x,y).toString().equals("contusion de la región lumbosacra y de la pelvis")||this.tblDiagnostico.getValueAt(x,y).toString().equals("contusión de la region lumbosacra y de la pelvis")||this.tblDiagnostico.getValueAt(x,y).toString().equals("contusion de la region lumbosacra y de la pelvis"))
            {
                cie10="S30.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismos superficiales múltiples del abdomen, de la región lumbosacra y de la pelvis")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismos superficiales multiples del abdomen, de la región lumbosacra y de la pelvis")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismos superficiales múltiples del abdomen, de la region lumbosacra y de la pelvis")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismos superficiales multiples del abdomen, de la region lumbosacra y de la pelvis"))
            {
                cie10="S30.7";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Herida del abdomen, de la región lumbosacra y de la pelvis")||this.tblDiagnostico.getValueAt(x,y).toString().equals("herida del abdomen, de la region lumbosacra y de la pelvis"))
            {
                cie10="S31";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Herida de la región lumbosacra y de la pelvis")||this.tblDiagnostico.getValueAt(x,y).toString().equals("herida de la region lumbosacra y de la pelvis"))
            {
                cie10="S31.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura de vértebra lumbar")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura de vertebra lumbar"))
            {
                cie10="S32.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura del sacro"))
            {
                cie10="S32.1";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura del hueso iliaco"))
            {
                cie10="S32.3";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura del acetábulo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura del acetabulo"))
            {
                cie10="S32.4";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura del pubis"))
            {
                cie10="S32.5";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Luxación, esguince y torcedura de articulaciones y ligamentos de la columna lumbar y de la pelvis")||this.tblDiagnostico.getValueAt(x,y).toString().equals("luxacion, esguince y torcedura de articulaciones y ligamentos de la columna lumbar y de la pelvis"))
            {
                cie10="S33";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Ruptura traumática de disco intervertebral lumbar")||this.tblDiagnostico.getValueAt(x,y).toString().equals("ruptura traumatica de disco intervertebral lumbar"))
            {
                cie10="S33.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Luxación de vértebra lumbar")||this.tblDiagnostico.getValueAt(x,y).toString().equals("luxacion de vértebra lumbar")||this.tblDiagnostico.getValueAt(x,y).toString().equals("luxación de vertebra lumbar")||this.tblDiagnostico.getValueAt(x,y).toString().equals("luxacion de vertebra lumbar"))
            {
                cie10="S33.1";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Luxación de articulación sacrococcígea y sacroiliaca")||this.tblDiagnostico.getValueAt(x,y).toString().equals("luxacion de articulacion sacrococcigea y sacroiliaca"))
            {
                cie10="S33.2";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Ruptura traumática de la sínfisis del pubis")||this.tblDiagnostico.getValueAt(x,y).toString().equals("ruptura traumatica de la sínfisis del pubis")||this.tblDiagnostico.getValueAt(x,y).toString().equals("ruptura traumática de la sinfisis del pubis")||this.tblDiagnostico.getValueAt(x,y).toString().equals("ruptura traumatica de la sinfisis del pubis"))
            {
                cie10="S33.4";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Esguinces y torceduras de la columna lumbar"))
            {
                cie10="S33.5";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Esguinces y torceduras de la articulación sacroiliaca")||this.tblDiagnostico.getValueAt(x,y).toString().equals("esguinces y torceduras de la articulacion sacroiliaca"))
            {
                cie10="S33.6";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Concusión y edema de la médula espinal lumbar")||this.tblDiagnostico.getValueAt(x,y).toString().equals("concusion y edema de la médula espinal lumbar")||this.tblDiagnostico.getValueAt(x,y).toString().equals("concusión y edema de la medula espinal lumbar")||this.tblDiagnostico.getValueAt(x,y).toString().equals("concusion y edema de la medula espinal lumbar"))
            {
                cie10="S34.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo de la cola de caballo"))
            {
                cie10="S34.3";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo del plexo lumbosacro"))
            {
                cie10="S34.4";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo de nervios simpáticos lumbares, sacros y pélvicos")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo de nervios simpaticos lumbares, sacros y pélvicos")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo de nervios simpáticos lumbares, sacros y pelvicos")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo de nervios simpaticos lumbares, sacros y pelvicos"))
            {
                cie10="S34.5";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo de nervios periféricos del abdomen, de la región lumbosacra y de la pelvis")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo de nervios perifericos del abdomen, de la región lumbosacra y de la pelvis")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo de nervios perifericos del abdomen, de la region lumbosacra y de la pelvis")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo de nervios periféricos del abdomen, de la region lumbosacra y de la pelvis"))
            {
                cie10="S34.6";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Contusión del hombro y del brazo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("contusion del hombro y del brazo"))
            {
                cie10="S40.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismos superficiales múltiples del hombro y del brazo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismos superficiales multiples del hombro y del brazo"))
            {
                cie10="S40.7";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Otros traumatismos superficiales del hombro y del brazo"))
            {
                cie10="S40.8";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Herida del hombro y del brazo"))
            {
                cie10="S41";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Herida del brazo"))
            {
                cie10="S41.1";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Heridas múltiples del hombro y del brazo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("heridas multiples del hombro y del brazo"))
            {
                cie10="S41.7";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura del hombro y del brazo"))
            {
                cie10="S42";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura de la clavícula")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura de la clavicula"))
            {
                cie10="S42.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura del omóplato")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura del omoplato"))
            {
                cie10="S42.1";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura de la epífisis superior del húmero")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura de la epífisis superior del humero")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura de la epifisis superior del húmero")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura de la epifisis superior del humero"))
            {
                cie10="S42.2";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura de la diáfisis del húmero")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura de la diáfisis del humero")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura de la diafisis del húmero")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura de la diafisis del humero"))
            {
                cie10="S42.3";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura de la epífisis inferior del húmero")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura de la epífisis inferior del humero")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura de la epifisis inferior del húmero")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura de la epifisis inferior del humero"))
            {
                cie10="S42.4";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fracturas múltiples de la clavícula, del omóplato y del húmero")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fracturas multiples de la clavicula, del omoplato y del humero"))
            {
                cie10="S42.7";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Luxación, esguince y torcedura de articulaciones y ligamentos de la cintura escapular")||this.tblDiagnostico.getValueAt(x,y).toString().equals("luxacion, esguince y torcedura de articulaciones y ligamentos de la cintura escapular"))
            {
                cie10="S43";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Luxación de la articulación del hombro")||this.tblDiagnostico.getValueAt(x,y).toString().equals("luxacion de la articulación del hombro")||this.tblDiagnostico.getValueAt(x,y).toString().equals("luxación de la articulacion del hombro")||this.tblDiagnostico.getValueAt(x,y).toString().equals("luxacion de la articulacion del hombro"))
            {
                cie10="S43.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Luxación de la articulación acromioclavicular")||this.tblDiagnostico.getValueAt(x,y).toString().equals("luxacion de la articulación acromioclavicular")||this.tblDiagnostico.getValueAt(x,y).toString().equals("luxación de la articulacion acromioclavicular")||this.tblDiagnostico.getValueAt(x,y).toString().equals("luxacion de la articulacion acromioclavicular"))
            {
                cie10="S43.1";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Luxación de la articulación esternoclavicular")||this.tblDiagnostico.getValueAt(x,y).toString().equals("luxacion de la articulación esternoclavicular")||this.tblDiagnostico.getValueAt(x,y).toString().equals("luxación de la articulacion esternoclavicular")||this.tblDiagnostico.getValueAt(x,y).toString().equals("luxacion de la articulacion esternoclavicular"))
            {
                cie10="S43.2";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Esguinces y torceduras de la articulación del hombro")||this.tblDiagnostico.getValueAt(x,y).toString().equals("esguinces y torceduras de la articulacion del hombro"))
            {
                cie10="S43.4";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Esguinces y torceduras de la articulación acromioclavicular")||this.tblDiagnostico.getValueAt(x,y).toString().equals("esguinces y torceduras de la articulacion acromioclavicular"))
            {
                cie10="S43.5";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Esguinces y torceduras de la articulación esternoclavicular")||this.tblDiagnostico.getValueAt(x,y).toString().equals("esguinces y torceduras de la articulacion esternoclavicular"))
            {
                cie10="S43.6";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo del nervio cubital a nivel del brazo"))
            {
                cie10="S44.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo del nervio mediano a nivel del brazo"))
            {
                cie10="S44.1";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo del nervio radial a nivel del brazo"))
            {
                cie10="S44.2";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo del nervio axilar"))
            {
                cie10="S44.3";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo del nervio musculocutáneo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del nervio musculocutaneo"))
            {
                cie10="S44.4";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo del nervio sensitivo cutáneo a nivel del hombro y del brazo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del nervio sensitivo cutaneo a nivel del hombro y del brazo"))
            {
                cie10="S44.5";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo de múltiples nervios a nivel del hombro y del brazo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo de multiples nervios a nivel del hombro y del brazo"))
            {
                cie10="S44.7";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo de nervio no especificado a nivel del hombro y del brazo"))
            {
                cie10="S44.9";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo del tendón del manguito rotatorio del brazo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del tendon del manguito rotatorio del brazo"))
            {
                cie10="S46.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo del tendón y músculo de otras partes del bícep")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del tendon y musculo de otras partes del bicep"))
            {
                cie10="S46.2";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo de múltiples tendones y músculos a nivel del hombro y del brazo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo de multiples tendones y músculos a nivel del hombro y del brazo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo de múltiples tendones y musculos a nivel del hombro y del brazo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo de multiples tendones y musculos a nivel del hombro y del brazo"))
            {
                cie10="S46.7";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo por aplastamiento del hombro y del brazo"))
            {
                cie10="S47";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Amputación traumática del hombro y del brazo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("amputacion traumática del hombro y del brazo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("amputación traumatica del hombro y del brazo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("amputacion traumatica del hombro y del brazo"))
            {
                cie10="S48";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Amputación traumática en la articulación del hombro")||this.tblDiagnostico.getValueAt(x,y).toString().equals("amputacion traumatica en la articulacion del hombro"))
            {
                cie10="S48.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Amputación traumática a nivel entre el hombro y el codo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("amputacion traumática a nivel entre el hombro y el codo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("amputación traumatica a nivel entre el hombro y el codo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("amputacion traumatica a nivel entre el hombro y el codo"))
            {
                cie10="S48.1";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Amputación traumática del hombro y del brazo, nivel no especificado")||this.tblDiagnostico.getValueAt(x,y).toString().equals("amputacion traumática del hombro y del brazo, nivel no especificado")||this.tblDiagnostico.getValueAt(x,y).toString().equals("amputación traumatica del hombro y del brazo, nivel no especificado")||this.tblDiagnostico.getValueAt(x,y).toString().equals("amputacion traumatica del hombro y del brazo, nivel no especificado"))
            {
                cie10="S48.9";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Contusión del codo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("contusion del codo"))
            {
                cie10="S50.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismos superficiales múltiples del antebrazo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismos superficiales multiples del antebrazo"))
            {
                cie10="S50.7";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Otros traumatismos superficiales del antebrazo"))
            {
                cie10="S50.8";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Herida del codo"))
            {
                cie10="S51.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Heridas múltiples del antebrazo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("heridas multiples del antebrazo"))
            {
                cie10="S51.7";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Herida del antebrazo parte no especificada"))
            {
                cie10="S51.9";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura de la epífisis superior del cúbito")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura de la epifisis superior del cúbito")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura de la epífisis superior del cubito")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura de la epifisis superior del cubito"))
            {
                cie10="S52.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura de la epífisis superior del radio")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura de la epifisis superior del radio"))
            {
                cie10="S52.1";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura de la diáfisis del cúbito")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura de la diafisis del cubito"))
            {
                cie10="S52.2";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura de la diáfisis del radio")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura de la diafisis del radio"))
            {
                cie10="S52.3";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura de la diáfisis del cúbito y del radio")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura de la diafisis del cubito y del radio"))
            {
                cie10="S52.4";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura de la epífisis inferior del radio")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura de la epífisis inferior del radio"))
            {
                cie10="S52.5";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura de la epífisis inferior del cúbito y del radio")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura de la epifisis inferior del cubito y del radio"))
            {
                cie10="S52.6";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fracturas múltiples del antebrazo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fracturas múltiples del antebrazo"))
            {
                cie10="S52.7";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Luxación de la cabeza del radio")||this.tblDiagnostico.getValueAt(x,y).toString().equals("luxacion de la cabeza del radio"))
            {
                cie10="S53.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Luxación del codo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("luxacion del codo"))
            {
                cie10="S53.1";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Ruptura traumática del ligamento lateral del radio")||this.tblDiagnostico.getValueAt(x,y).toString().equals("ruptura traumatica del ligamento lateral del radio"))
            {
                cie10="S53.2";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Ruptura traumática del ligamento lateral del cúbito")||this.tblDiagnostico.getValueAt(x,y).toString().equals("ruptura traumatica del ligamento lateral del cubito"))
            {
                cie10="S53.3";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Esguinces y torceduras del codo"))
            {
                cie10="S53.4";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo del nervio cubital a nivel del antebrazo"))
            {
                cie10="S54.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo del nervio mediano a nivel del antebrazo"))
            {
                cie10="S54.1";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo del nervio radial a nivel del antebrazo"))
            {
                cie10="S54.2";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo del nervio sensorial cutáneo a nivel del antebrazo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del nervio sensorial cutaneo a nivel del antebrazo"))
            {
                cie10="S54.3";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo de múltiples nervios del antebrazo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo de multiples nervios del antebrazo"))
            {
                cie10="S54.7";
            }
            //----------------------------------------------------------------------------------------------------------------------------------------------------------//
            
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo del tendón y músculo flexor del pulgar a nivel del antebrazo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del tendon y músculo flexor del pulgar a nivel del antebrazo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del tendón y musculo flexor del pulgar a nivel del antebrazo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del tendon y musculo flexor del pulgar a nivel del antebrazo"))
            {
                cie10="S56.0";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo del tendón y músculo flexor de otros dedos a nivel del antebrazo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del tendon y músculo flexor de otros dedos a nivel del antebrazo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del tendón y musculo flexor de otros dedos a nivel del antebrazo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del tendon y musculo flexor de otros dedos a nivel del antebrazo"))
            {
                cie10="S56.1";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo del tendón y músculo flexor a nivel del antebrazo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del tendon y músculo flexor a nivel del antebrazo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del tendón y musculo flexor a nivel del antebrazo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del tendon y musculo a nivel del antebrazo"))
            {
                cie10="S56.2";
             }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo de tendones y músculos abductores y extensores del pulgar a nivel del antebrazo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo de tendones y musculos abductores y extensores del pulgar a nivel del antebrazo"))
            {
                cie10="S56.3";           
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo del tendón y músculo extendor de otros dedos a nivel del antebrazo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del tendon y músculo extendor de otros dedos a nivel del antebrazo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del tendón y musculo extendor de otros dedos a nivel del antebrazo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del tendon y musculo extendor de otros dedos a nivel del antebrazo"))
            {
                cie10="S56.4";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Amputación traumática a nivel del codo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("apuntacion traumática a nivel del codo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("apuntación traumatica a nivel del codo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("apuntacion traumatica a nivel del codo"))
            {
                cie10="S58.0";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Amputación traumática nivel entre el codo y la muñeca")||this.tblDiagnostico.getValueAt(x,y).toString().equals("apuntacion traumática a nivel entre el codo y la muñeca")||this.tblDiagnostico.getValueAt(x,y).toString().equals("apuntación traumatica nivel entre el codo y la muñeca")||this.tblDiagnostico.getValueAt(x,y).toString().equals("apuntacion traumatica nivel entre el codo y la muñeca"))
            {
                cie10="S58.1";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Contusión de dedos de la mano, sin daño de las uñas")||this.tblDiagnostico.getValueAt(x,y).toString().equals("contusion de dedos de la mano, sin daño de las uñas"))
            {
                cie10="S60.0";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Contusión de dedos de la mano, con daño de las uñas")||this.tblDiagnostico.getValueAt(x,y).toString().equals("contusion de dedos de la mano, con daño de las uñas"))
            {
                cie10="S60.1";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Contusión de las otras partes de la muñeca y de la mano")||this.tblDiagnostico.getValueAt(x,y).toString().equals("contusion de las otras partes de la muñeca y de la mano"))
            {
                cie10="S60.2";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Herida de dedos de la mano, sin daño de las uñas"))
            {
                cie10="S61.0";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Herida de dedos de la mano, con daño de las uñas"))
            {
                cie10="S61.1";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Heridas múltiples de la muñeca y de la mano")||this.tblDiagnostico.getValueAt(x,y).toString().equals("heridas multiples de la muñeca y de la mano"))
            {
                cie10="S61.7";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura del hueso escafoides navicular de la mano"))
            {
                cie10="S62.0";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura de otros huesos del carpo"))
            {
                cie10="S62.1";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura del primer metacarpiano"))
            {
                cie10="S62.2";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fracturas de otros huesos del carpo"))
            {
                cie10="S62.3";
            }
              if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fracturas múltiples de huesos metacarpianos")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fracturas multiples de huesos metacarpianos"))
            {
                cie10="S62.4";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura del pulgar"))
            {
                cie10="S62.5";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Luxación de la muñeca")||this.tblDiagnostico.getValueAt(x,y).toString().equals("luxacion de la muñeca"))
            {
                cie10="S63.0";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Luxación de los dedos de la muñeca")||this.tblDiagnostico.getValueAt(x,y).toString().equals("luxacion de los dedos de la muñeca"))
            {
                cie10="S63.1";
            }
     
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Luxaciones múltiples de dedos de la mano")||this.tblDiagnostico.getValueAt(x,y).toString().equals("luxaciones multiples de dedos de la mano"))
            {
                cie10="S63.2";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Ruptura traumática de ligamentos de la muñeca y del carpo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("ruptura traumatica de ligamentos de la muñeca y del carpo"))
            {
                cie10="S63.3";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Ruptura traumática de ligamentos de dedos de la mano en las articulaciónes metacarpofalángica e interfalángica")||this.tblDiagnostico.getValueAt(x,y).toString().equals("ruptura traumatica de ligamentos de dedos de la mano en las articulaciónes metacarpofalángica e interfalángica")||this.tblDiagnostico.getValueAt(x,y).toString().equals("ruptura traumática de ligamentos de dedos de la mano en las articulaciones metacarpofalángica e interfalángica")||this.tblDiagnostico.getValueAt(x,y).toString().equals("ruptura traumática de ligamentos de dedos de la mano en las articulaciónes metacarpofalangica e interfalángica")||this.tblDiagnostico.getValueAt(x,y).toString().equals("ruptura traumática de ligamentos de dedos de la mano en las articulaciónes metacarpofalángica e interfalangica")||this.tblDiagnostico.getValueAt(x,y).toString().equals("ruptura traumatica de ligamentos de dedos de la mano en las articulaciones metacarpofalangica e interfalangica"))
            {
                cie10="S63.4";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Esguinces y torceduras de dedos de la mano"))
            {
                cie10="S63.6";
            } 
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Esguinces y torceduras de otras partes y de las no especificadas de la muñeca y de la mano"))
            {
                cie10="S63.7";
            } 
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo del nervio cubital a nivel de la muñeca y de la mano"))
            {
                cie10="S64.0";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo del nervio mediano a nivel de la muñeca y de la mano"))
            {
                cie10="S64.1";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo del nervio radial a nivel de la muñeca y de la mano"))
            {
                cie10="S64.2";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo del nervio digital del pulgar"))
            {
                cie10="S64.3";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo del nervio digital de otro dedo"))
            {
                cie10="S64.4";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo del tendón y músculo flexor de otro dedo a nivel de la muñeca y de la mano")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del tendon y músculo flexor de otro dedo a nivel de la muñeca y de la mano")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del tendón y musculo flexor de otro dedo a nivel de la muñeca y de la mano")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del tendon y musculo flexor de otro dedo a nivel de la muñeca y de la mano"))
            {
                cie10="S66.1";
            } 
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo del tendón y músculo extensor del pulgar a nivel de la muñeca y de la mano")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del tendon y músculo extensor del pulgar a nivel de la muñeca y de la mano")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del tendón y musculo extensor del pulgar a nivel de la muñeca y de la mano")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del tendon y musculo extensor del pulgar a nivel de la muñeca y de la mano"))
            {
                cie10="S66.2";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo del tendón y músculo extensor de otros dedos a nivel de la muñeca y de la mano")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del tendon y músculo extensor de otros dedos a nivel de la muñeca y de la mano")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del tendón y musculo extensor de otros dedos a nivel de la muñeca y de la mano")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del tendon y musculo extensor de otros dedos a nivel de la muñeca y de la mano"))
            {
                cie10="S66.3";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo del músculo y tendón intrínseco del pulgar a nivel de la muñeca y de la mano")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del musculo y tendón intrínseco del pulgar a nivel de la muñeca y de la mano")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del músculo y tendon intrinseco del pulgar a nivel de la muñeca y de la mano")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del músculo y tendón intrinseco del pulgar a nivel de la muñeca y de la mano")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del musculo y tendon intrinseco del pulgar a nivel de la muñeca y de la mano"))
            {
                cie10="S66.4";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo del músculo y tendón intrínseco de otros dedos a nivel de la muñeca y de la mano")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del musculo y tendón intrínseco de otros dedos a nivel de la muñeca y de la mano")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del músculo y tendon intrínseco de otros dedos a nivel de la muñeca y de la mano")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del músculo y tendón intrinseco de otros dedos a nivel de la muñeca y de la mano")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del musculo y tendon intrinseco de otros dedos a nivel de la muñeca y de la mano"))
            {
                cie10="S66.5";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo de múltiples tendones y músculo flexores a nivel de la muñeca y de la mano")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo de multiples tendones y músculo flexores a nivel de la muñeca y de la mano")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo de múltiples tendones y musculo flexores a nivel de la muñeca y de la mano")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo de multiples tendones y musculo flexores a nivel de la muñeca y de la mano"))
            {
                cie10="S66.6";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo de múltiples tendones y músculo extensores a nivel de la muñeca y de la mano")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo de multiples tendones y músculo extensores a nivel de la muñeca y de la mano")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo de múltiples tendones y musculo extensores a nivel de la muñeca y de la mano")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo de multiples tendones y musculo extensores a nivel de la muñeca y de la mano"))
            {
                cie10="S66.7";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo de otros tendones y músculos a nivel de la muñeca y de la mano")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo de otros tendones y musculos a nivel de la muñeca y de la mano"))
           {
                cie10="S66.8";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo por aplastamiento de otras partes y de las no especificadas de la muñeca y de la mano"))
            {
                cie10="S67.8";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Amputación traumática de la muñeca y de la mano")||this.tblDiagnostico.getValueAt(x,y).toString().equals("amputacion traumática de la muñeca y de la mano")||this.tblDiagnostico.getValueAt(x,y).toString().equals("amputación traumatica de la muñeca y de la mano")||this.tblDiagnostico.getValueAt(x,y).toString().equals("amputacion traumatica de la muñeca y de la mano"))
            {
                cie10="S68";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Amputación traumática del pulgar completa parcial")||this.tblDiagnostico.getValueAt(x,y).toString().equals("amputacion traumática del pulgar completa parcial")||this.tblDiagnostico.getValueAt(x,y).toString().equals("amputación traumatica del pulgar completa parcial")||this.tblDiagnostico.getValueAt(x,y).toString().equals("amputacion traumatica del pulgar completa parcial"))
            {
                cie10="S68.0";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Amputación traumática de otro dedo único completa parcial")||this.tblDiagnostico.getValueAt(x,y).toString().equals("amputacion traumática de otro dedo único completa parcial")||this.tblDiagnostico.getValueAt(x,y).toString().equals("amputación traumatica de otro dedo único completa parcial")||this.tblDiagnostico.getValueAt(x,y).toString().equals("amputación traumática de otro dedo unico completa parcial")||this.tblDiagnostico.getValueAt(x,y).toString().equals("amputacion traumatica de otro dedo unico completa parcial"))
            {
                cie10="S68.1";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Amputación traumática de dos o más dedos solamente completa parcial")||this.tblDiagnostico.getValueAt(x,y).toString().equals("amputacion traumática de dos o más dedos solamente completa parcial")||this.tblDiagnostico.getValueAt(x,y).toString().equals("amputación traumatica de dos o más dedos solamente completa parcial")||this.tblDiagnostico.getValueAt(x,y).toString().equals("amputación traumática de dos o mas dedos solamente completa parcial")||this.tblDiagnostico.getValueAt(x,y).toString().equals("amputacion traumatica de dos o mas dedos solamente completa parcial"))
            {
                cie10="S68.2";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Amputación traumática de la mano nivel de la muñeca")||this.tblDiagnostico.getValueAt(x,y).toString().equals("amputacion traumática de la mano nivel de la muñeca")||this.tblDiagnostico.getValueAt(x,y).toString().equals("amputación traumatica de la mano nivel de la muñeca")||this.tblDiagnostico.getValueAt(x,y).toString().equals("amputacion traumatica de la mano nivel de la muñeca"))
            {
                cie10="S68.4";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Contusión de la cadera")||this.tblDiagnostico.getValueAt(x,y).toString().equals("contusion de la cadera"))
            {
                cie10="S70.0";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Contusión del muslo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("contusion del muslo"))
            {
                cie10="S70.1";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismos superficiales múltiples de la cadera y del muslo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismos superficiales multiples de la cadera y del muslo"))
            {
                cie10="S70.7";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Otros traumatismos superficiales de la cadera y del muslo"))
            {
                cie10="S70.8";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Herida de la cadera"))
            {
                cie10="S71.0";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Herida del muslo"))
            {
                cie10="S71.1";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Heridas múltiples de la cadera y del muslo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("heridas multiples de la cadera y del muslo"))
            {
                cie10="S71.7";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura del cuello de fémur")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura del cuello de femur"))
            {
                cie10="S72.0";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura pertrocanteriana"))
            {
                cie10="S72.1";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura subtrocanteriana"))
            {
                cie10="S71.2";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura de la diálisis del fémur")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura de la dialisis del fémur")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura de la dialisis del femur")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura de la dialisis del femur"))
            {
                cie10="S72.3";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura de la epífisis interior del fémur")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura de la epifisis interior del fémur")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura de la epífisis interior del femur")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura de la epifisis interior del femur"))
            {
                cie10="S72.4";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fracturas múltiples del fémur")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fracturas multiples del fémur")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fracturas múltiples del femur")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fracturas multiples del femur"))
            {
                cie10="S72.7";
            } 
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fracturas de otras partes del fémur")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fracturas de otras partes del femur"))
            {
                cie10="S72.8";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Luxación de la cadera")||this.tblDiagnostico.getValueAt(x,y).toString().equals("luxacion de la cadera"))
            {
                cie10="S73.0";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Esguines y torceduras e la cadea"))
            {
                cie10="S73.1";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo del nervio ciático a nivel de la cadera y del muslo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del nervio ciatico a nivel de la cadera y del muslo"))
            {
                cie10="S74.0";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo del nervio femorocuatáneo a nivel de la cadera y del muslo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del nervio femorocuataneo a nivel de la cadera y del muslo"))
            {
                cie10="S74.1";
            } 
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo de nervios múltiples a nivel de la cadera y del muslo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo de nervios multiples a nivel de la cadera y del muslo"))
            {
                cie10="S74.7";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo del tendón y músculo de la cadera")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del tendon y músculo de la cadera")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del tendón y musculo de la cadera")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del tendon y muslo de la cadera"))
            {
                cie10="S76.0";
            } 
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo del tendón músculo cuádriceps")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del tendon músculo cuádriceps")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del tendón musculo cuádriceps")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del tendón músculo cuadriceps")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del tendon musculo cuadriceps"))
            {
                cie10="S76.1";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo del tendón y músculo aductor mayor del muslo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del tendon y músculo aductor mayor del muslo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del tendón y musculo aductor mayor del muslo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del tendon y musculo aductor mayor del muslo"))
            {
                cie10="S76.2";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo del tendón y músculo del grupo muscular posterior a nivel del muslo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del tendon y músculo del grupo muscular posterior a nivel del muslo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del tendón y musculo del grupo muscular posterior a nivel del muslo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del tendon y musculo del grupo muscular posterior a nivel del muslo"))
            {
                cie10="S76.3";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo de otros tendones y músculos y los no especificados a nivel del muslo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo de otros tendones y musculos y los no especificados a nivel del muslo"))
            {
                cie10="S76.4";
            }
             if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo de múltiples tendones y músculo a nivel de la cadera y del muslo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo de multiples tendones y músculo a nivel de la cadera y del muslo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo de múltiples tendones y musculo a nivel de la cadera y del muslo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo de multiples tendones y musculo a nivel de la cadera y del muslo"))
            {
                cie10="S76.7";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Contusión de la rodilla")||this.tblDiagnostico.getValueAt(x,y).toString().equals("contusion de la rodilla"))
            {
                cie10="S80.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Otros traumatismos superficiales de la pierna"))
            {
                cie10="S80.8";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Herida de la rodilla"))
            {
                cie10="S81.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Heridas múltiples de la pierna")||this.tblDiagnostico.getValueAt(x,y).toString().equals("heridas multiples de la pierna"))
            {
                cie10="S81.7";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura de la rótula")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura de la rotula"))
            {
                cie10="S82.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura de la epífisis superior de la tibia")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura de la epifisis superior de la tibia"))
            {
                cie10="S82.1";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura de la diáfisis de la tibia")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura de la diafisis de la tibia"))
            {
                cie10="S82.2";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura de la epífisis inferior de la tibia")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura de la epifisis inferior de la tibia"))
            {
                cie10="S82.3";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura del peroné solamente")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura del perone solamente"))
            {
                cie10="S82.4";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura del maléolo interno")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura del maléolo interno"))
            {
                cie10="S82.5";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura del maléolo externo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura del maléolo externo"))
            {
                cie10="S82.6";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura múltiples de la pierna")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fracturas multiples de la pierna"))
            {
                cie10="S82.7";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Luxación de la rótula")||this.tblDiagnostico.getValueAt(x,y).toString().equals("luxacion de la rótula")||this.tblDiagnostico.getValueAt(x,y).toString().equals("luxación de la rotula")||this.tblDiagnostico.getValueAt(x,y).toString().equals("luxacion de la rotula"))
            {
                cie10="S83.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Luxación de la rodilla")||this.tblDiagnostico.getValueAt(x,y).toString().equals("luxacion de la rodilla"))
            {
                cie10="S83.1";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Desgarro de meniscos"))
            {
                cie10="S83.2";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Desgarro del cartílago articular de la rodilla")||this.tblDiagnostico.getValueAt(x,y).toString().equals("desgarro del cartilago articular de la rodilla"))
            {
                cie10="S83.3";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Esguinces y torceduras que comprometen los ligamentos laterales"))
            {
                cie10="S83.4";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Esguinces y torceduras que comprometen el ligamento cruzado"))
            {
                cie10="S83.5";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Esguinces y torceduras de otras partes y no especificadas de la rodilla"))
            {
                cie10="S83.6";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo de estructuras múltiples de la rodilla")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo de estructuras multiples de la rodilla"))
            {
                cie10="S83.7";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo del nervio tibial a nivel de la pierna"))
            {
                cie10="S84.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo del nervio peroneo a nivel de la pierna"))
            {
                cie10="S84.1";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo de otros nervios a nivel de la pierna"))
            {
                cie10="S84.8";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo del tendón de aquiles")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del tendon de aquiles"))
            {
                cie10="S86.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo de otros tendones y músculos del grupo muscular posterior a nivel de la pierna")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo de otros tendones y musculos del grupo muscular posterior a nivel de la pierna"))
            {
                cie10="S86.1";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo de tendones y músculos del grupo muscular anterior a nivel de la pierna")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo de otros tendones y musculos del grupo muscular anterior a nivel de la pierna"))
            {
                cie10="S86.2";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo de tendones y músculos del grupo muscular peroneo a nivel de la pierna")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo de otros tendones y musculos del grupo muscular peroneo a nivel de la pierna"))
            {
                cie10="S86.3";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo de múltiples tendones y músculos a nivel de la pierna")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo de multiples tendones y musculos a nivel de la pierna"))
            {
                cie10="S86.7";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo de otros tendones y músculos a nivel de la pierna")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo de otros tendones y musculos a nivel de la pierna"))
            {
                cie10="S86.8";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo de tendón y músculo no especificado a nivel de la pierna")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo tendon y musculo no especificado a nivel de la pierna"))
            {
                cie10="S86.9";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo por aplastamiento de la pierna"))
            {
                cie10="S87";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Amputación traumática de la pierna")||this.tblDiagnostico.getValueAt(x,y).toString().equals("amputacion traumatica de la pierna"))
            {
                cie10="S88";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Amputación traumática a nivel de la rodilla")||this.tblDiagnostico.getValueAt(x,y).toString().equals("amputacion traumatica a nivel de la rodilla"))
            {
                cie10="S88.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Amputación traumática en algún nivel entre la rodilla y el tobillo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("amputacion traumatica en algún nivel entre la rodilla y el tobillo"))
            {
                cie10="S88.1";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Contusión del tobillo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("contusion del tobillo"))
            {
                cie10="S90.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Contusión de dedos del pie sin daño de las uñas")||this.tblDiagnostico.getValueAt(x,y).toString().equals("contusion de dedos del pie sin daño de las uñas"))
            {
                cie10="S90.1";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Contusión de dedos del pie con daño de las uñas")||this.tblDiagnostico.getValueAt(x,y).toString().equals("contusion de dedos del pie con daño de las uñas"))
            {
                cie10="S90.2";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Contusión de otras partes y de las no especificadas del pie")||this.tblDiagnostico.getValueAt(x,y).toString().equals("contusion de otras partes y de las no especificadas del pie"))
            {
                cie10="S90.3";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismos superficiales múltiples del pie y del tobillo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismos superficiales multiples del pie y del tobillo"))
            {
                cie10="S90.7";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Herida del tobillo"))
            {
                cie10="S91.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Herida de dedos del pie sin daño de las uñas"))
            {
                cie10="S91.1";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Herida de dedos del pie con daño de las uñas"))
            {
                cie10="S91.2";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Herida de otras partes del pie"))
            {
                cie10="S91.3";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura del calcáneo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura del calcaneo"))
            {
                cie10="S92.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura del astrágalo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("fractura del astragalo"))
            {
                cie10="S92.1";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura de otros huesos del tarso"))
            {
                cie10="S92.2";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura de hueso del metatarso"))
            {
                cie10="S92.3";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura los huesos del dedo gordo del pie"))
            {
                cie10="S92.4";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Fractura los huesos de otros huesos del pie"))
            {
                cie10="S92.5";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Luxación de la articulación del tobillo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("luxacion de la articulacion del tobillo"))
            {
                cie10="S93.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Luxación de dedos del pie")||this.tblDiagnostico.getValueAt(x,y).toString().equals("luxacion de dedos del pie"))
            {
                cie10="S93.1";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Ruptura de ligamentos a nivel del tobillo y del pie"))
            {
                cie10="S93.2";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Luxación de otros sitios y los no especificados del pie")||this.tblDiagnostico.getValueAt(x,y).toString().equals("luxacion otros sitios y de los no especificados del pie"))
            {
                cie10="S93.3";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Esguinces y torceduras del tobillo"))
            {
                cie10="S93.4";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Esguinces y torceduras de dedos del pie"))
            {
                cie10="S93.5";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo del nervio peroneal profundo a nivel del pie y del tobillo"))
            {
                cie10="S94.2";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo de otros nervios a nivel del pie y del tobillo"))
            {
                cie10="S94.8";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo del tendón y músculo del flexor largo del dedo a nivel del pie y del tobillo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del tendon y musculo del flexor largo del dedo a nivel del pie y del tobillo"))
            {
                cie10="S96.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo del tendón y músculo del extensor largo de los dedos a nivel del pie y del tobillo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo del tendon y musculo del extensor largo de los dedos a nivel del pie y del tobillo"))
            {
                cie10="S96.1";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo de tendones y músculos intrínsecos a nivel del pie y del tobillo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo de tendones y musculos intrinsecos a nivel del pie y del tobillo"))
            {
                cie10="S96.2";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo de múltiples tendones y músculos a nivel del pie y del tobillo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo de múltiples tendones y musculos a nivel del pie y del tobillo"))
            {
                cie10="S96.7";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo de otros tendones y músculos a nivel del pie y del tobillo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismo de otros tendones y musculos a nivel del pie y del tobillo"))
            {
                cie10="S96.8";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo por aplastamiento de dedos del pie"))
            {
                cie10="S97.1";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismo por aplastamiento de otras partes del pie y del tobillo"))
            {
                cie10="S97.8";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Amputación traumática del pie y del tobillo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("amputacion traumatica del pie y del tobillo"))
            {
                cie10="S98";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Amputación traumática del pie a nivel del tobillo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("amputacion traumática del pie a nivel del tobillo"))
            {
                cie10="S98.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Amputación traumática de un dedo del pie")||this.tblDiagnostico.getValueAt(x,y).toString().equals("amputacion traumática de un dedo del pie"))
            {
                cie10="S98.1";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Amputación traumática de dos o más dedos del pie")||this.tblDiagnostico.getValueAt(x,y).toString().equals("amputacion traumática de dos o mas dedos del pie"))
            {
                cie10="S98.2";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismos superficiales que afectan múltiples regiones de los miembros superiores")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismos superficiales que afectan multiples regiones de los miembros superiores"))
            {
                cie10="T00.2";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismos superficiales que afectan múltiples regiones de los miembros inferiores")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismos superficiales que afectan multiples regiones de los miembros inferiores"))
            {
                cie10="T00.3";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Traumatismos superficiales que afectan otras combinaciones de regiones del cuerpo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("traumatismos superficiales que afectan otrad combinaciones de regiones del cuerpo"))
            {
                cie10="T00.8";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Quemadura de la cabeza y del cuello, grado no especificado"))
            {
                cie10="T20.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Quemadura de la cabeza y del cuello, de primer grado"))
            {
                cie10="T20.1";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Quemadura de la cabeza y del cuello, de segundo grado"))
            {
                cie10="T20.2";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Quemadura de la cabeza y del cuello, de tercer grado"))
            {
                cie10="T20.3";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Quemadura del tronco, grado no especificado"))
            {
                cie10="T21.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Quemadura del tronco, de primer grado"))
            {
                cie10="T21.1";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Quemadura del tronco, de segundo grado"))
            {
                cie10="T21.2";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Quemadura del tronco, de tercer grado"))
            {
                cie10="T21.3";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Quemadura del hombro y miembro superior, grado no especificado, excepto de la muñeca de la mano"))
            {
                cie10="T22.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Quemadura del hombro y miembro superior, primer grado, excepto de la muñeca de la mano"))
            {
                cie10="T22.1";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Quemadura de la muñeca y de la mano, grado no especificado"))
            {
                cie10="T23.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Quemadura de la muñeca y de la mano, de primer grado"))
            {
                cie10="T23.1";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Quemadura de la muñeca y de la mano, de segundo grado"))
            {
                cie10="T23.2";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Quemadura de la muñeca y de la mano, de tercer grado"))
            {
                cie10="T23.3";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Quemadura de la cadera y miembro inferior, grado no especificado, excepto tobillo y pie"))
            {
                cie10="T24.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Quemadura de la cadera y miembro inferior, de primer grado, excepto tobillo y pie"))
            {
                cie10="T24.1";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Quemadura de la cadera y miembro inferior, de segundo grado, excepto tobillo y pie"))
            {
                cie10="T24.2";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Quemadura de la cadera y miembro inferior, de tercer grado, excepto tobillo y pie"))
            {
                cie10="T24.3";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Quemadura del tobillo y pie, grado no especificado"))
            {
                cie10="T25.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Quemadura del tobillo y pie, de primer grado"))
            {
                cie10="T25.1";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Quemadura del tobillo y pie, de segundo grado"))
            {
                cie10="T25.2";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Quemadura del tobillo y pie, de tercer grado"))
            {
                cie10="T25.3";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Embolia gaseosa"))
            {
                cie10="T79.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Embolia grasa"))
            {
                cie10="T79.1";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Hemorragia traumática secundaria y recurrente")||this.tblDiagnostico.getValueAt(x,y).toString().equals("hemorragia traumatica secundaria y recurrente"))
            {
                cie10="T79.2";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Infección postraumática de herida, no clasificada en otra parte")||this.tblDiagnostico.getValueAt(x,y).toString().equals("hemorragia postraumatica de herida, no clasificada en otra parte"))
            {
                cie10="T79.3";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Hemorragia y hematoma que complican un procedimiento, no clasificados en otra parte"))
            {
                cie10="T81.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Desgarro de herida operatoria, no clasificado en otra parte"))
            {
                cie10="T81.3";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Complicación mecánica de prótesis articular interna")||this.tblDiagnostico.getValueAt(x,y).toString().equals("complicacion mecanica de protesis articular interna"))
            {
                cie10="T84.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Complicación mecánica de dispositivo de fijación interna de huesos de un miembro")||this.tblDiagnostico.getValueAt(x,y).toString().equals("complicacion mecanica de dispositivo de fijacion interna de huesos de un miembro"))
            {
                cie10="T84.1";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Complicación mecánica de dispositivo de fijación interna de otros huesos")||this.tblDiagnostico.getValueAt(x,y).toString().equals("complicacion mecanica de dispositivo de fijacion interna de otros huesos"))
            {
                cie10="T84.2";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Complicación mecánica de otros dispositivos óseos, implantes e injertos")||this.tblDiagnostico.getValueAt(x,y).toString().equals("complicacion mecanica de otros dispositivos oseos, implantes e injertos"))
            {
                cie10="T84.3";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Complicación mecánica de otros dispositivos protésicos, implantes e injertos ortopédicos internos")||this.tblDiagnostico.getValueAt(x,y).toString().equals("complicacion mecanica de otros dispositivos protesicos, implantes e injertos ortopedicos internos"))
            {
                cie10="T84.4";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Infección y reacción inflamatoria debidas a prótesis articular interna")||this.tblDiagnostico.getValueAt(x,y).toString().equals("infeccion y reaccion inflamatoria debidas a protesis articular interna"))
            {
                cie10="T84.5";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Infección y reacción inflamatoria debidas a dispositivo de fijación interna")||this.tblDiagnostico.getValueAt(x,y).toString().equals("infeccion y reaccion inflamatoria debidas a dispositivo de fijacion interna"))
            {
                cie10="T84.6";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Infección y reacción inflamatoria debidas a otros dispositivos protésicos, implantes e injertos ortopédicos internos")||this.tblDiagnostico.getValueAt(x,y).toString().equals("infeccion y reaccion inflamatoria debidas a otros dispositivos protesicos, implantes e injertos ortopedicos internos"))
            {
                cie10="T84.7";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Otras complicaciones de dispositivos protésicos, implantes e injertos ortopédicos internos")||this.tblDiagnostico.getValueAt(x,y).toString().equals("otras complicaciones de dispositivos protesicos, implantes e injertos ortopedicos internos"))
            {
                cie10="T84.8";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Neuroma de muñón de amputación")||this.tblDiagnostico.getValueAt(x,y).toString().equals("neuroma de muñon de amputacion"))
            {
                cie10="T87.3";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Infección de muñón de amputación")||this.tblDiagnostico.getValueAt(x,y).toString().equals("infeccion de muñon de amputacion"))
            {
                cie10="T87.4";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Necrosis de muñón de amputación")||this.tblDiagnostico.getValueAt(x,y).toString().equals("necrosis de muñon de amputacion"))
            {
                cie10="T87.5";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Otras complicaciones y las no especificadas de muñón de amputación")||this.tblDiagnostico.getValueAt(x,y).toString().equals("otras complicaciones y las no especificadas de muñon de amputacion"))
            {
                cie10="T87.6";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Secuelas de fractura del cráneo y de huesos faciales")||this.tblDiagnostico.getValueAt(x,y).toString().equals("secuelas de fractura del craneo y de huesos faciales"))
            {
                cie10="T90.2";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Secuelas de fractura de la columna vertebral"))
            {
                cie10="T91.1";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Secuelas de traumatismo de la médula espinal")||this.tblDiagnostico.getValueAt(x,y).toString().equals("secuelas de traumatismo de la medula espinal"))
            {
                cie10="T91.3";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Secuelas de herida de miembro superior"))
            {
                cie10="T92.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Secuelas de fractura del brazo"))
            {
                cie10="T92.1";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Secuelas de fractura de la muñeca y de la mano"))
            {
                cie10="T92.2";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Secuelas de luxación, torcedura y esguince de miembro superior"))
            {
                cie10="T92.3";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Secuelas de traumatismo de nervio y de miembro superior"))
            {
                cie10="T92.4";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Secuelas de traumatismo de tendón y músculo de miembro superior")||this.tblDiagnostico.getValueAt(x,y).toString().equals("secuelas de traumatismo de tendon y musculo de miembro superior"))
            {
                cie10="T92.5";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Secuelas de herida de miembro inferior"))
            {
                cie10="T93.0";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Secuelas de fractura del fémur")||this.tblDiagnostico.getValueAt(x,y).toString().equals("secuelas de fractura del femur"))
            {
                cie10="T93.1";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Secuelas de otras fracturas de miembro inferior")||this.tblDiagnostico.getValueAt(x,y).toString().equals("secuelas de otras fracturas de miembro inferior"))
            {
                cie10="T93.2";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Secuelas de luxación, torcedura y esguince de miembro inferior")||this.tblDiagnostico.getValueAt(x,y).toString().equals("secuelas de luxacion, torcedura y esguince de miembro inferior"))
            {
                cie10="T93.3";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Secuelas de traumatismo de nervio de miembro inferior"))
            {
                cie10="T93.4";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Secuelas de traumatismo de tendón y músculo de miembro inferior")||this.tblDiagnostico.getValueAt(x,y).toString().equals("secuelas de traumatismo de tendon y musculo de miembro inferior"))
            {
                cie10="T93.5";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Secuelas de aplastamiento y amputación traumáticas de miembro inferior")||this.tblDiagnostico.getValueAt(x,y).toString().equals("secuelas de aplastamiento y amputacion traumaticas de miembro inferior"))
            {
                cie10="T93.6";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Secuelas de otros traumatismos especificados de miembro inferior"))
            {
                cie10="T93.8";
            }
            if(this.tblDiagnostico.getValueAt(x,y).toString().equals("Secuelas de traumatismos que afectan múltiples regiones del cuerpo")||this.tblDiagnostico.getValueAt(x,y).toString().equals("secuelas de traumatismos que afectan múltiples regiones del cuerpo"))
            {
                cie10="T94.0";
            }

            
            if(txtDiaRep.getText().equals("1"))
            {
                numDiasTexto = "Uno";
            }
            if(txtDiaRep.getText().equals("2"))
            {
                numDiasTexto = "Dos";
            }
            if(txtDiaRep.getText().equals("3"))
            {
                numDiasTexto = "Tres";
            }
            if(txtDiaRep.getText().equals("4"))
            {
                numDiasTexto = "Cuatro";
            }
            if(txtDiaRep.getText().equals("5"))
            {
                numDiasTexto = "Cinco";
            }
            if(txtDiaRep.getText().equals("6"))
            {
                numDiasTexto = "Seis";
            }
            if(txtDiaRep.getText().equals("7"))
            {
                numDiasTexto = "Siete";
            }
            if(txtDiaRep.getText().equals("8"))
            {
                numDiasTexto = "Ocho";
            }
            if(txtDiaRep.getText().equals("9"))
            {
                numDiasTexto = "Nueve";
            }
            if(txtDiaRep.getText().equals("10"))
            {
                numDiasTexto = "Diez";
            }
            if(txtDiaRep.getText().equals("11"))
            {
                numDiasTexto = "Once";
            }
            if(txtDiaRep.getText().equals("12"))
            {
                numDiasTexto = "Doce";
            }
            if(txtDiaRep.getText().equals("13"))
            {
                numDiasTexto = "Trece";
            }
            if(txtDiaRep.getText().equals("14"))
            {
                numDiasTexto = "Catorce";
            }
            if(txtDiaRep.getText().equals("15"))
            {
                numDiasTexto = "Quince";
            }
            if(txtDiaRep.getText().equals("16"))
            {
                numDiasTexto = "Dieciseis";
            }
            if(txtDiaRep.getText().equals("17"))
            {
                numDiasTexto = "Diecisiete";
            }
            if(txtDiaRep.getText().equals("18"))
            {
                numDiasTexto = "Dieciocho";
            }
            if(txtDiaRep.getText().equals("19"))
            {
                numDiasTexto = "Diecinueve";
            }
            if(txtDiaRep.getText().equals("20"))
            {
                numDiasTexto = "Veinte";
            }
            if(txtDiaRep.getText().equals("21"))
            {
                numDiasTexto = "Veintiuno";
            }
            if(txtDiaRep.getText().equals("22"))
            {
                numDiasTexto = "Veintidos";
            }
            if(txtDiaRep.getText().equals("23"))
            {
                numDiasTexto = "Veintitres";
            }
            if(txtDiaRep.getText().equals("24"))
            {
                numDiasTexto = "Veinticuatro";
            }
            if(txtDiaRep.getText().equals("25"))
            {
                numDiasTexto = "Veinticinco";
            }
            if(txtDiaRep.getText().equals("26"))
            {
                numDiasTexto = "Veintiseis";
            }
            if(txtDiaRep.getText().equals("27"))
            {
                numDiasTexto = "Veintisiete";
            }
            if(txtDiaRep.getText().equals("28"))
            {
                numDiasTexto = "Veintiocho";
            }
            if(txtDiaRep.getText().equals("29"))
            {
                numDiasTexto = "Veintinueve";
            }
            if(txtDiaRep.getText().equals("30"))
            {
                numDiasTexto = "Treinta";
            }
            if(txtDiaRep.getText().equals("31"))
            {
                numDiasTexto = "Treintiuno";
            }
            if(txtDiaRep.getText().equals("32"))
            {
                numDiasTexto = "Treintidos";
            }
            if(txtDiaRep.getText().equals("33"))
            {
                numDiasTexto = "Treintitres";
            }
            if(txtDiaRep.getText().equals("34"))
            {
                numDiasTexto = "Treinticuatro";
            }
            if(txtDiaRep.getText().equals("35"))
            {
                numDiasTexto = "Treinticinco";
            }
            if(txtDiaRep.getText().equals("36"))
            {
                numDiasTexto = "Treintiseis";
            }
            if(txtDiaRep.getText().equals("37"))
            {
                numDiasTexto = "Treintisiete";
            }
            if(txtDiaRep.getText().equals("38"))
            {
                numDiasTexto = "Treintiocho";
            }
            if(txtDiaRep.getText().equals("39"))
            {
                numDiasTexto = "Treintinueve";
            }
            if(txtDiaRep.getText().equals("40"))
            {
                numDiasTexto = "Cuarenta";
            }
            
            
            //Ingreso de la consulta
            if(lblImagen.getText().isEmpty())
            {
                MainController entra = new MainController();
                entra.insertarConsulta(txtMotCon.getText(), txtExaFis.getText(),txtExamenes.getText() , txtTraInd.getText(), this.tblDiagnostico.getValueAt(x,y).toString(), txtDiaRep.getText(), numDiasTexto,txtNumCed.getText(),proximaConsulta,cie10,"",receta.getText(),indicaciones.getText());
                JOptionPane.showMessageDialog(this, "Consulta ingresada con éxito");

            }
            else{
                               MainController entra = new MainController();
                entra.insertarConsulta(txtMotCon.getText(), txtExaFis.getText(),txtExamenes.getText() , txtTraInd.getText(), this.tblDiagnostico.getValueAt(x,y).toString(), txtDiaRep.getText(), numDiasTexto,txtNumCed.getText(),proximaConsulta,cie10,lblImagen.getText(),receta.getText(),indicaciones.getText());
                JOptionPane.showMessageDialog(this, "Consulta ingresada con éxito");

            }
            
            try
        {
        //Consultar el Id de la consulta para no generar repetidos
            MainController entra = new MainController();
            String id = entra.IdConsulta(txtNumCed.getText()); 
            
            
        //Creación del Reporte
            Map <String, Object> mapa = new HashMap<String,Object>();
            mapa.put("cedulaPaciente", "%"+txtNumCed.getText()+"%");
            MainController conexion = new MainController();
            JasperReport reporte = JasperCompileManager.compileReport("consulta.jrxml");
            JasperPrint jprint = JasperFillManager.fillReport(reporte, mapa, conexion.conexion());
            JasperExportManager.exportReportToPdfFile(jprint,"consulta"+id+".pdf");
            JOptionPane.showMessageDialog(this,"Consulta generada con éxito");
            
            Process p = Runtime.getRuntime().exec ("rundll32 SHELL32.DLL,ShellExec_RunDLL "+"D:\\TraumatologiaDrGalarza\\dist\\consulta"+id+".pdf");
            
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "No se puede abrir el archivo de ayuda, probablemente fue borrado","ERROR",JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(IngresoConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtDiaRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiaRepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaRepActionPerformed

    private void buscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscaKeyReleased
                DefaultTableModel dtm= new DefaultTableModel();
                this.tblDiagnostico.getSelectionModel().setSelectionInterval(0,0);
                dtm = (DefaultTableModel) this.tblDiagnostico.getModel();
                TableRowSorter <DefaultTableModel> trs = new TableRowSorter<>(dtm);
                tblDiagnostico.setRowSorter(trs);
                trs.setRowFilter(RowFilter.regexFilter(this.busca.getText()));
    }//GEN-LAST:event_buscaKeyReleased

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int resultado;
        EleccionArchivo buscador = new EleccionArchivo();
        FileNameExtensionFilter formato = new FileNameExtensionFilter("JPG","PNG" ,"GIF","jpg","png","gif","jpeg");
        buscador.JFCImg.setFileFilter(formato);
        resultado = buscador.JFCImg.showOpenDialog(this);
        if(JFileChooser.APPROVE_OPTION==resultado){
            archivo = buscador.JFCImg.getSelectedFile();
            lblImagen.setText(archivo.getAbsolutePath());
            
            try {
                ImageIcon imgIcon = new ImageIcon(archivo.toString());
                Icon icono = new ImageIcon(imgIcon.getImage().getScaledInstance(lblImagenPrevia.getWidth(), lblImagenPrevia.getHeight(), Image.SCALE_DEFAULT));
                lblImagenPrevia.setIcon(icono);
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Error al abrir el archivo");
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCedulaActionPerformed
            
            if(!txtEdad.getText().isEmpty()){
                txtNomPac.setText("");
                txtTelefono.setText("");
                txtEdad.setText("");
                txtNumCed.setText("");
                txtSexPac.setText("");
                txtRes.setText("");
                txtEstCiv.setText("");
                txtOcu.setText("");
                txtTelefono.setText("");
            }
            
            try
            {
                
                MainController entra = new MainController();
                datosPaciente = entra.consultaDatosPacienteCedula(txtNumCed.getText());
                txtNomPac.setText((String) datosPaciente.get(0));
                txtTelefono.setText((String)datosPaciente.get(1));
                txtEdad.setText((String)datosPaciente.get(2));
                txtNumCed.setText((String)datosPaciente.get(3));
                txtSexPac.setText((String) datosPaciente.get(4));
                txtRes.setText((String) datosPaciente.get(5));
                txtEstCiv.setText((String) datosPaciente.get(6));
                txtOcu.setText((String) datosPaciente.get(7));
                txtTelefono.setText((String) datosPaciente.get(8));
            
            } catch(Exception e) {
                JOptionPane.showMessageDialog(this, "Ingrese paciente por favor");
            }
            
            //Consulta de las fechas de atención de paciente
            
            fechas = (DefaultTableModel) tblFecha.getModel();
            ArrayList listaFechas  = new  ArrayList<>();
            ArrayList auxDatosFactura = new ArrayList<>();
            MainController entra = new MainController();
            listaFechas = entra.consultaTodoFechas(txtNumCed.getText());            
            Iterator <String> itFecha = listaFechas.iterator();
            
            fechas.setColumnIdentifiers(new Object[] {"Fechas"});
              //Mostrar todas las facturas
            if(listaFechas.size()>1) //Aqui cambio
            {
              for(int i=0;i<listaFechas.size();i++)
              {
                    auxDatosFactura.add(listaFechas.get(i));
                    if (i % 1 == 0) //aqui cambio
                    {
                        ArrayList nuevo = new ArrayList<>();
                        for(int k=0; k<1;k++)
                        {
                          nuevo.add(listaFechas.get(contador));
                          contador++;
                        }
                        fechas.addRow(nuevo.toArray());
                    }
              }  
            }
            else
            {
                fechas.addRow(listaFechas.toArray());
            }
            tblFecha.setModel(fechas);
            //Agregando el mouseListener
            eventoMouseListener();
       
    }//GEN-LAST:event_btnCedulaActionPerformed

    private void txtOcuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOcuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOcuActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
         
        MainController ingreso = new MainController();
        ingreso.insertarPaciente(txtNumCed.getText(), txtNomPac.getText(),txtSexPac.getText(), txtRes.getText(), txtEstCiv.getText(), txtOcu.getText(),txtEdad.getText(),txtTelefono.getText());
        JOptionPane.showMessageDialog(this, "Paciente ingresado correctamente");

    }//GEN-LAST:event_jButton7ActionPerformed

    private void txtEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdadActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void eventoMouseListener(){
        MouseListener ml = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if(!txtExamenes.getText().isEmpty())
                {
                    txtMotCon.setText("");
                    txtExaFis.setText("");
                    txtExamenes.setText("");
                    busca.setText("");
                    txtTraInd.setText("");
                    receta.setText("");
                    indicaciones.setText("");
                    txtDiaRep.setText("");
                    lblImagen.setText("");
                    lblImagenPrevia.setIcon(null);
                }
                ArrayList listaTabla = new ArrayList<>();
                int x=tblFecha.getSelectedRow();
                int y=tblFecha.getSelectedColumn();

                MainController entra = new MainController();
                listaTabla =entra.obtenerDatosTabla(tblFecha.getValueAt(x, y).toString());
                
                txtMotCon.setText(listaTabla.get(0).toString());
                txtExaFis.setText(listaTabla.get(1).toString());
                txtExamenes.setText(listaTabla.get(2).toString());
                busca.setText(listaTabla.get(3).toString());
                txtTraInd.setText(listaTabla.get(4).toString());
                receta.setText(listaTabla.get(5).toString());
                indicaciones.setText(listaTabla.get(6).toString());
                txtDiaRep.setText(listaTabla.get(7).toString());
                lblImagen.setText(listaTabla.get(8).toString());
                ImageIcon imagen = new ImageIcon(listaTabla.get(8).toString());
                Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lblImagenPrevia.getWidth(), lblImagenPrevia.getHeight(), Image.SCALE_DEFAULT));
                lblImagenPrevia.setIcon(icono);
            }
            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }
        };
        
        tblFecha.addMouseListener(ml);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IngresoConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngresoConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngresoConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresoConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngresoConsulta().setVisible(true);
                
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCedula;
    private javax.swing.JTextField busca;
    private javax.swing.JTextArea indicaciones;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblImagenPrevia;
    private javax.swing.JTextArea receta;
    private javax.swing.JTable tblDiagnostico;
    private javax.swing.JTable tblFecha;
    private javax.swing.JTextField txtDiaRep;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtEstCiv;
    private javax.swing.JTextArea txtExaFis;
    private javax.swing.JTextArea txtExamenes;
    private javax.swing.JTextArea txtMotCon;
    private javax.swing.JTextField txtNomPac;
    private javax.swing.JTextField txtNumCed;
    private javax.swing.JTextField txtOcu;
    private javax.swing.JTextField txtRes;
    private javax.swing.JTextField txtSexPac;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextArea txtTraInd;
    // End of variables declaration//GEN-END:variables
}
