/*
 * Copyright (C) 2000 - 2013 Silverpeas
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * As a special exception to the terms and conditions of version 3.0 of
 * the GPL, you may redistribute this Program in connection withWriter Free/Libre
 * Open Source Software ("FLOSS") applications as described in Silverpeas's
 * FLOSS exception.  You should have recieved a copy of the text describing
 * the FLOSS exception, and it is also available here:
 * "http://www.silverpeas.org/legal/licensing"
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.silverpeas.migration.jcr.service;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

/**
 *
 * @author ehugonnet
 */
public class ConverterUtilTest {

  public ConverterUtilTest() {
  }

  /**
   * Test of extractLanguage method, of class ConverterUtil.
   */
  @Test
  public void testExtractLanguage() {
    String filename = "6961wysiwyg_de.txt";
    String result = ConverterUtil.extractLanguage(filename);
    Assert.assertThat(result, is("de"));
    filename = "6961wysiwyg_fr.txt";
    result = ConverterUtil.extractLanguage(filename);
    Assert.assertThat(result, is("fr"));
    filename = "6961wysiwyg.txt";
    result = ConverterUtil.extractLanguage(filename);
    Assert.assertThat(result, is(Matchers.nullValue()));
    filename = "Node_1939wysiwyg.txt";
    result = ConverterUtil.extractLanguage(filename);
    Assert.assertThat(result, is(Matchers.nullValue()));
  }

  /**
   * Test of extractLanguage method, of class ConverterUtil.
   */
  @Test
  public void testExtractBaseName() {
    String filename = "6961wysiwyg_de.txt";
    String result = ConverterUtil.extractBaseName(filename);
    Assert.assertThat(result, is("6961wysiwyg"));
    filename = "6961wysiwyg_fr.txt";
    result = ConverterUtil.extractBaseName(filename);
    Assert.assertThat(result, is("6961wysiwyg"));
    filename = "6961wysiwyg.txt";
    result = ConverterUtil.extractBaseName(filename);
    Assert.assertThat(result, is("6961wysiwyg"));
    filename = "Node_1939wysiwyg.txt";
    result = ConverterUtil.extractBaseName(filename);
    Assert.assertThat(result, is(Matchers.nullValue()));
  }

}
