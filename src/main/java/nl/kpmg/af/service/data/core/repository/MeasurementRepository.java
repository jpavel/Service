/*
 * Copyright 2016 KPMG N.V. (unless otherwise stated).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package nl.kpmg.af.service.data.core.repository;

import nl.kpmg.af.service.data.core.Measurement;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 *
 * @author mhoekstra
 */
public interface MeasurementRepository
    extends PagingAndSortingRepository<Measurement, Long>, MeasurementRepositoryCustom {

  public List<Measurement> findAll();

  public List<Measurement> findByVersion(int version);

}
