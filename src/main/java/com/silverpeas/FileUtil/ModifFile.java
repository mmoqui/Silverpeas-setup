package com.silverpeas.FileUtil;

/**
 * Titre : gestion de fichier
 * Description : class abstraite pour la gestion de fichier
 * Copyright :    Copyright (c) 2001
 * Soci�t� :
 * @author Thomas pellegrin
 * @version 1.0
 */

import java.io.*;
import java.io.File;
import java.util.*;

public abstract class ModifFile {
/**
 * Chaine du fichier � modifier
 */
  protected String path=null;
  /**
   * tableau des modification � effectuer les objets contenue dans ce tableau sont de type
   * ElementModif ou ElementMultiValues
   */
  protected ArrayList listeModifications;

  /**
   * isModified indique si le fichier a ete modifie
   */
  protected boolean isModified = false;

  /**
   * @constructor constructeur de la class
   */
  public ModifFile() {
	  listeModifications= new ArrayList();
  }

   /**
   * @constructor prend en param�tre le chemin du fichier � modifier
   */
  public ModifFile(String path) throws Exception{
	  listeModifications= new ArrayList();
	  setPath(path);
  }

/**
 * met � jour le chemin du fichier � modifier
 */
  protected void setPath(String src) throws Exception {
	File file = new File(src);
	if (file.exists()!=true){
	  throw new Exception("Le fichier \""+src+"\" n'existe pas");
	}else{
	  path=src;
	}
  }

/**
 * copy un fichier pass� en param�tre dans le fichier out
 */
  public static void copyFile(File in, File out) throws Exception {
	byte[] buf = new byte[1024];
	FileInputStream sIn  = new FileInputStream(in);
	FileOutputStream sOut = new FileOutputStream(out);
	int i = 0;
	while((i=sIn.read(buf))!=-1) {
			 sOut.write(buf, 0, i);
	}
	sIn.close();
	sOut.close();
  }

/**
 * ajoute une modification au fichier
 * les param�tres: chaine de recherche, chaine de remplacement
 */
  public void addModification(String pSearch, String pModif){
	listeModifications.add(new ElementModif(pSearch,pModif));
  }

/**
 * ajoute une modification au fichier param�tre: un ElementModif
 */
  public void addModification(ElementModif em){
	listeModifications.add(em);
  }


  /**
 * ajoute une modification au fichier param�tre: chaine de type "key=value"
 */
  public void addModification(String pModif)throws Exception{
	int index = pModif.lastIndexOf("=");
	if (index!=-1){
	  listeModifications.add(new ElementModif(pModif.substring(0,index-1),
								pModif.substring(index+1,pModif.length())));
	}else{
	  throw new Exception("la chaine \""+pModif+"\" n'est pas standard \"key=modif\"");
	}
  }

  /**
   * creer une copy de fichier *.bak par defaut (si parametre est � null)
   *  sinon la valeur du param�tre pass�.
   */

  public void createFileBak(String str) throws Exception{
        File file= new File(path);
        File newFile;
	if (file.exists() && file.isFile()){
	  if (str==null){
		  newFile = new File(path+".bak");
	  }else{
		newFile = new File(str);
	  }
	  copyFile(file,newFile);
	}else{
		throw new Exception("Le fichier :\""+path+"\" n'existe pas ou n'est pas un fichier");
	}
  }

   /**
   * methode abstraite pour la modification du fichier
   */
  protected abstract void executeModification() throws Exception;

}