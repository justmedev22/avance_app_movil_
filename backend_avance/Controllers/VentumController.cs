using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using backend_avance.Models;

namespace backend_avance.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class VentumController : ControllerBase
    {
        private readonly bdavancetechContext _context;

        public VentumController(bdavancetechContext context)
        {
            _context = context;
        }

        // GET: api/Ventum
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Ventum>>> GetVenta()
        {
            return await _context.Venta.ToListAsync();
        }

        // GET: api/Ventum/5
        [HttpGet("{id}")]
        public async Task<ActionResult<Ventum>> GetVentum(int id)
        {
            var ventum = await _context.Venta.FindAsync(id);

            if (ventum == null)
            {
                return NotFound();
            }

            return ventum;
        }

        // PUT: api/Ventum/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> PutVentum(int id, Ventum ventum)
        {
            if (id != ventum.IdVenta)
            {
                return BadRequest();
            }

            _context.Entry(ventum).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!VentumExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return NoContent();
        }

        // POST: api/Ventum
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<Ventum>> PostVentum(Ventum ventum)
        {
            _context.Venta.Add(ventum);
            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateException)
            {
                if (VentumExists(ventum.IdVenta))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtAction("GetVentum", new { id = ventum.IdVenta }, ventum);
        }

        // DELETE: api/Ventum/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteVentum(int id)
        {
            var ventum = await _context.Venta.FindAsync(id);
            if (ventum == null)
            {
                return NotFound();
            }

            _context.Venta.Remove(ventum);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool VentumExists(int id)
        {
            return _context.Venta.Any(e => e.IdVenta == id);
        }
    }
}
