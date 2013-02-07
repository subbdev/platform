package org.apache.maven.scm.provider.git.command.update;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.util.List;

import org.apache.maven.scm.ScmFile;
import org.apache.maven.scm.command.update.UpdateScmResultWithRevision;

/**
 * @author <a href="mailto:trygvis@inamo.no">Trygve Laugst&oslash;l</a>
 * @version $Id: GitUpdateScmResult.java 1057016 2011-01-09 20:11:26Z olamy $
 * @deprecated
 */
public class GitUpdateScmResult
    extends UpdateScmResultWithRevision
{
    private static final long serialVersionUID = 7360578324181996847L;

    public GitUpdateScmResult( String commandLine, List<ScmFile> updatedFiles, int revision )
    {
        super( commandLine, updatedFiles, String.valueOf( revision ) );
    }
}